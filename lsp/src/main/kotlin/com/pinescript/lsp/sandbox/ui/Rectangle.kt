package com.pinescript.lsp.sandbox.ui

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

import com.pinescript.core.PineMetaObject
import com.pinescript.core.PineObject
import com.pinescript.core.boolProp
import com.pinescript.core.intProp
import com.pinescript.core.stringProp
import java.awt.Color
import javax.swing.JPanel

class Rectangle(id: Int) : PineObject(id) {

    companion object {
        val meta = PineMetaObject("Rectangle") { Rectangle(it) }
    }

    val panel = JPanel(null)

    var x: Int by intProp(::x, initialValue = 1)
    var y: Int by intProp(::y, initialValue = 1)
    var width: Int by intProp(::width, initialValue = 50)
    var height: Int by intProp(::height, initialValue = 50)
    var visible: Boolean by boolProp(::visible, initialValue = true)
    val color: String by stringProp(::color, initialValue = "#ffffff")

    init {
        connect("x") { resizeSlot() }
        connect("y") { resizeSlot() }
        connect("width") { resizeSlot() }
        connect("height") { resizeSlot() }
        connect("visible") { resizeSlot() }
        connect("color") { panel.background = Color.decode(color) }

        panel.background = Color.decode(color)

        connect("children") {
            panel.removeAll()
            for (child in children) {
                if (child is Rectangle) {
                    panel.add(child.panel)
                }
                if (child is Label) {
                    panel.add(child.label)
                }
            }
        }
        resizeSlot()
    }

    override fun getMeta(): PineMetaObject = meta

    private fun resizeSlot() {
        panel.bounds = java.awt.Rectangle(x, y, width, height)
        panel.isVisible = visible
    }
}
