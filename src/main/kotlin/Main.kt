import com.flex.core.PineObject
import com.flex.core.QMLEngine
import com.flex.ui.Rectangle
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea
import org.fife.ui.rsyntaxtextarea.SyntaxConstants
import org.fife.ui.rtextarea.RTextScrollPane
import java.awt.BorderLayout
import java.awt.Dimension
import java.lang.Exception
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JSplitPane
import javax.swing.SwingUtilities
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener


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
3. Neither the name of Tom Everett nor the names of its contributors
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
    var outputPanel  = JPanel(null)
    var scriptEngine = QMLEngine.Builder()
        .registerQMLType( "Rectangle") { Rectangle() }
        .build()

    init {
        title = "Pine Script Live"
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
        minimumSize = Dimension(1000, 500)
        bounds = java.awt.Rectangle(10, 10 ,1000, 500)
        contentPane.layout = BorderLayout()
        contentPane.add(JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, createTextEditor(), outputPanel))

        textArea.document.addDocumentListener( object: DocumentListener {
            override fun changedUpdate(e: DocumentEvent?) = runScript(textArea.text)
            override fun insertUpdate(e: DocumentEvent?) = runScript(textArea.text)
            override fun removeUpdate(e: DocumentEvent?) = runScript(textArea.text)
        })
        pack()
    }

    private fun runScript(script: String) {
        try {
            root?.getProp("visible")?.asBool()?.setValue(false)
            root = scriptEngine.load(textArea.text)
            outputPanel.removeAll()
            outputPanel.add((root as Rectangle).panel)
        } catch(e: Exception) {
            root = null
            println(e.message)
        }
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

    SwingUtilities.invokeLater { MainWindow().isVisible = true }
//    val root = engine.load("""
//       import QtQuick 1.0;
//       Page {
//            visible: true
//            title: "This"
//            Page {
//              title: "is"
//              visible: true
//            }
//            Page {
//              title: "test"
//              visible: true
//            }
//       }
//        """.trimIndent()) as Window
//
//    root.getProp(root::visible).connect { println("Hello world") }
//    root.visible = true
    //root.show(root.getProperty("visible")!!.get() as Boolean)
}