import com.flex.core.QMLEngine
import com.flex.core.QtObject
import com.flex.ui.Window
import javax.swing.JFrame
import javax.swing.JLabel

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

fun main(argv: Array<String>) {
    val engine = QMLEngine.Builder()
        .registerQMLType("QtQuick", "QtObject", QtObject::class)
        .registerQMLType("QtQuick", "Window", Window::class)
        .build()

    val root = engine.load(
        "import QtQuick 1.0; " +
                "Window { " +
                "visible: true" +
                "} ") as Window

    print(root.getProperty("visible")!!.get())
//    // lambda to print property name
//    val slot = { println(root.getProperty("myProp").toString()) }
//    // connecting lambda to "myProp" it will be triggered
//    // when "myProp" changes..
//    root.connect("myProp", slot)
//    // set new object to my prop
//    root.getProperty("myProp")!!.set(QtObject())

    root.show(root.getProperty("visible")!!.get() as Boolean)
}