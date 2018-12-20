package com.flex.core

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

import com.flex.core.expression.QMLExpression
import java.util.concurrent.CopyOnWriteArrayList

class QMLBinding(internal var expression: QMLExpression?) {

    private var targets: MutableList<() -> Unit> = CopyOnWriteArrayList()
    private var dependencies: MutableList<QMLProperty> = CopyOnWriteArrayList()
    private var value: Any? = null

    internal val signal = QMLSignal()

    var enabled = true

    internal fun enabled(): Boolean {
        return this.enabled
    }

    fun addTarget(target: () -> Unit) {
        targets.add(target)
        signal.connect(target)
    }

    fun removeTarget(target: () -> Unit) {
        targets.remove(target)
        signal.disconnect(target)
    }

    fun addDependency(dependency: QMLProperty) {
        this.dependencies.add(dependency)
        dependency.signal.connect { this.refresh() }
    }

    fun removeDependency(dependency: QMLProperty) {
        this.dependencies.remove(dependency)
        dependency.signal.disconnect { this.refresh() }
    }

    private fun refresh() {
        if (expression != null) {
            val newValue = expression!!.evaluate()
            if (newValue != value) {
                value = newValue
                signal.emit()
            }
        }
    }

    fun getValue(): Any? {
        //@TODO: cache value to make it efficient
        return expression!!.evaluate()
    }
}
