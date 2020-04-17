import com.pinescript.core.PineEngine
import com.pinescript.core.PineObject
import com.pinescript.core.PineScriptParseException
import com.pinescript.core.PineValue
import com.pinescript.lsp.*
import com.pinescript.lsp.models.*
import com.pinescript.lsp.ui.Label
import com.pinescript.lsp.ui.Rectangle
import io.ktor.util.KtorExperimentalAPI
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import org.fife.ui.rtextarea.RTextScrollPane
import java.awt.BorderLayout
import java.awt.Dimension
import java.lang.Thread.sleep
import javax.swing.*
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import kotlin.system.measureTimeMillis


/*
BSD License

Copyright (c) 2018, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Paulo Pinheiro nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

class MainWindow : JFrame() {

    var root: PineObject? = null
    var textArea = RSyntaxTextArea(20, 40)
    var outputPanel = JPanel(null)
    var scriptEngine = PineEngine.Builder()
        .registerPineType(Rectangle.meta)
        .registerPineType(Label.meta)
        .build()

    init {
        title = "Pine Script Live"
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        minimumSize = Dimension(1200, 500)
        bounds = java.awt.Rectangle(10, 10, 1000, 500)
        contentPane.layout = BorderLayout()
        contentPane.add(JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, createTextEditor(), outputPanel))

        textArea.document.addDocumentListener(object : DocumentListener {
            override fun changedUpdate(e: DocumentEvent?) = runScript()
            override fun insertUpdate(e: DocumentEvent?) = runScript()
            override fun removeUpdate(e: DocumentEvent?) = runScript()
        })
        pack()
    }

    private fun runScript() {
        try {
            root?.getProp("visible")?.asType<Boolean>()?.value = PineValue.of(false)
            root?.dispose()
            val loadTime = measureTimeMillis { root = scriptEngine.load(textArea.text) }
            println("Script Parser in $loadTime ms")
            outputPanel.removeAll()
            outputPanel.add((root as Rectangle).panel)
            outputPanel.repaint()
        } catch (e: Exception) {
            root = null
            outputPanel.removeAll()
            outputPanel.add(errorLabel(e))
            outputPanel.repaint()
            e.printStackTrace()
            println(e.message)
        }
    }

    private fun errorLabel(e: Exception): JLabel {
        val label = JLabel(e.stackTrace.joinToString(
            separator = "<br>",
            prefix = "<html> <b>${e.message}</b><br><br>",
            postfix = "</html>",
            limit = 5
        ) { it.toString() })

        label.size = label.preferredSize
        label.setLocation(10, 10)
        label.isVisible = true
        return label
    }

    private fun createTextEditor(): JPanel {
        val cp = JPanel(BorderLayout())
        cp.minimumSize = Dimension(500, 500)
        textArea.syntaxEditingStyle = SyntaxConstants.SYNTAX_STYLE_CSS
        textArea.isAutoIndentEnabled = true
        textArea.isBracketMatchingEnabled = true
        textArea.closeCurlyBraces = true
        textArea.markOccurrences = true
        textArea.tabSize = 2
        textArea.tabsEmulated = true
        val sp = RTextScrollPane(textArea)
        cp.add(sp)
        return cp
    }
}

class ServerImpl(private val pineEngine: PineEngine) : LSPDelegate {

    var docItem: TextDocumentItem? = null

    override fun onInitialize(capabilities: LSPInitializeParams): LSPInitializeServerResult {

        val workspaceFolders = capabilities.capabilities.workspace?.workspaceFolders == true
        return LSPInitializeServerResult(
            capabilities = JsonRPCServerCapabilitiesImpl(
                textDocumentSync = TextDocumentSyncKind.Full,//TextDocumentSync(),
                completionProvider = CompletionProvider(resolveProvider = true),
                workspace = if (workspaceFolders) WorkspaceFoldersServerCapabilities(WorkspaceFoldersCapabilities(true)) else null
            ),
            serverInfo = LSPServerInfo("PineLang Server")
        )
    }

    override fun onInitialized() {}
    override fun onShutdown() {}

    override fun onTextDocumentDidOpen(doc: TextDocumentDidOpenParams): PublishDiagnosticsParams {
        docItem = doc.textDocument
        return generateDiagnostic(doc.textDocument.text)
    }

    override fun onTextDocumentDocumentSymbol(docIdentifier: TextDocumentDocumentSymbolParams): LSPDiagnostic {
        return LSPDiagnostic(
            Range(
                Position(0, 0),
                Position(0, 0)
            ), 3, ""
        )
    }


    override fun onTextDocumentDidChange(didChangeTextDoc: TextDocumentDidChangeParams): PublishDiagnosticsParams {
        println("$didChangeTextDoc")
        docItem = docItem?.copy(text = didChangeTextDoc.contentChanges[0].text)
        return generateDiagnostic(didChangeTextDoc.contentChanges[0].text)
    }

    override fun onTextDocumentCompletion(documentCompletionParams: TextDocumentCompletionParams): LSPCompletionList {
        println("onTextDocumentCompletion")
        val text = docItem!!.text
        val incomplete = text.getWordAtPosition(documentCompletionParams.position) ?: ""
        val objType = text.getObjectTypeEnclosingPosition(documentCompletionParams.position)

        val propertyCompletionList = objType?.run {
            val type = pineEngine.types[objType] ?: return@run null
            (type.propNames() + listOf("id"))
                .filter { it != "children" }
                .filter { it.contains(incomplete) }
                .map {
                    CompletionItem(
                        label = it,
                        insertText = "$it:",
                        detail = "Property",
                        kind = CompletionItemKind.Field.value
                    )
                } +
                    type.signalNames()
                        .filter { it.contains(incomplete) }
                        .map {
                            CompletionItem(
                                label = it,
                                insertText = "on $it:",
                                detail = "Signal",
                                kind = CompletionItemKind.Event.value
                            )
                        } +
                    type.callableNames()
                        .filter { it.contains(incomplete) }
                        .map {
                            CompletionItem(
                                label = it,
                                insertText = "$it()",
                                detail = "Function",
                                kind = CompletionItemKind.Function.value
                            )
                        }
        } ?: listOf()

        val objCompletionList = pineEngine.compiler.types.index.keys
            .filter { it.contains(incomplete) }
            .map {
                CompletionItem(
                    label = "$it {",
                    detail = "Type",
                    kind = CompletionItemKind.Class.value
                )
            }
        return LSPCompletionList(isIncomplete = false, items = propertyCompletionList + objCompletionList)
    }

    private fun PineScriptParseException.toRange(): Range {
        return Range(
            Position(this.startLine - 1, this.startCol),
            Position(this.endLine - 1, this.endCol + 1)
        )
    }

    private fun generateDiagnostic(script: String): PublishDiagnosticsParams {
        return try {
            val ast = pineEngine.compile(script)
            println("AST: $ast")
            PublishDiagnosticsParams(
                uri = docItem!!.uri,
                diagnostics = listOf()
            )
        } catch (e: PineScriptParseException) {
            println("error: ${e.message}")
            PublishDiagnosticsParams(
                uri = docItem!!.uri,
                diagnostics = listOf(
                    LSPDiagnostic(
                        e.toRange(),
                        3,
                        severity = 1,
                        message = e.message!!,
                        source = "Pine Compiler"
                    )
                )
            )
        }
    }
}

@KtorExperimentalAPI
fun main(argv: Array<String>) {
    //SwingUtilities.invokeLater { MainWindow().isVisible = true }
    val pineEngine = PineEngine.Builder().build()
    val server = LSPServer(ServerImpl(pineEngine))
    server.startServer("localhost", 8080)
    while (true) {
        sleep(1000)
    }
}