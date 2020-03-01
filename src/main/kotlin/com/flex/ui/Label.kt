package com.flex.ui

import com.flex.core.PineObject
import java.awt.Color
import java.awt.Dimension
import java.awt.Panel
import javax.swing.JLabel
import javax.swing.JPanel


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

class Label : Item() {
    val label = JLabel("oh my god")

    var text: String by stringProp(::text, initialValue = "") { resizeSlot() }
    var visible: Boolean by boolProp(::visible, initialValue = true) { resizeSlot() }
    val color: String by stringProp(::color, initialValue = "#000000") { label.foreground = Color.decode(color) }

    init {
        connect((this as Item)::x) { resizeSlot() }
        connect((this as Item)::y) { resizeSlot() }
        connect((this as Item)::width) { resizeSlot() }
        connect((this as Item)::height) { resizeSlot() }

        resizeSlot()

        childrenChanged.connect {
            label.removeAll()
            for (child in children) {
                if (child is Rectangle) {
                    label.add(child.panel)
                }
            }
        }
    }

    private fun resizeSlot() {
        label.foreground = Color.decode(color)
        label.text = text
        label.size = Dimension(width, height)
//        label.size = label.preferredSize
        label.setLocation(x, y)
        label.isVisible = visible
    }
}