import com.pinescript.core.PineEngine
import com.pinescript.core.PineObject
import com.pinescript.core.PineValue
import com.pinescript.lsp.LSPServer
import com.pinescript.lsp.ServerImpl
import com.pinescript.lsp.sandbox.ui.Label
import com.pinescript.lsp.sandbox.ui.Rectangle
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

class MainWindow(val engine: PineEngine, enableEditor: Boolean) : JFrame() {

    var root: PineObject? = null
    var textArea = RSyntaxTextArea(20, 40)
    var outputPanel = JPanel(null)


    init {
        title = "Pine Script Live"
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        minimumSize = Dimension(1200, 500)
        bounds = java.awt.Rectangle(10, 10, 1000, 500)
        contentPane.layout = BorderLayout()
        if (enableEditor) {
            contentPane.add(JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, createTextEditor(), outputPanel))
            textArea.document.addDocumentListener(object : DocumentListener {
                override fun changedUpdate(e: DocumentEvent?) = runScript(textArea.text)
                override fun insertUpdate(e: DocumentEvent?) = runScript(textArea.text)
                override fun removeUpdate(e: DocumentEvent?) = runScript(textArea.text)
            })
        } else {
            contentPane.add(outputPanel)
        }

        pack()
    }

    fun runScript(text: String) {
        try {
            root?.getProp("visible")?.asType<Boolean>()?.value = PineValue.of(false)
            root?.dispose()
            root = engine.load(text)
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

fun main(argv: Array<String>) {
    val pineEngine = PineEngine.Builder()
            .registerPineType(Rectangle.meta)
            .registerPineType(Label.meta)
            .build()

    val window = MainWindow(pineEngine, false)
    SwingUtilities.invokeLater { window.isVisible = true }
    val serverImpl = ServerImpl(pineEngine)
    serverImpl.textChangeListener = { window.runScript(it ) }
    val server = LSPServer(serverImpl)
    server.startNettyServer("localhost", 20001)

    while (true) {
        sleep(1000)
    }
}