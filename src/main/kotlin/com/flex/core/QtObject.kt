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

import java.util.*

open class QtObject : QMLObject {

    final override var id: Long
    override var children: MutableList<QMLObject> = mutableListOf()
    override val declaredProperties: MutableList<QMLProperty> = mutableListOf()


    private var parent: QMLObject? = null
    protected val context = QMLContext()

    constructor() {
        this.id = -1
        setParent(null)
    }

    constructor(id: Long, parent: QMLObject?) {
        this.id = id
        setParent(parent)
    }

    override fun getChildrenAt(pos: Int): QMLObject {
        return children[pos]
    }

    override fun getParent(parent: QMLObject): QMLObject {
        return parent
    }

    final override fun setParent(parent: QMLObject?) {
        if (this.parent != null) {
            this.parent!!.removeChild(this)
        }

        this.parent = parent

        parent?.addChild(this)
    }

    override fun addDynamicProperty(property: QMLProperty) {
        declaredProperties.add(
            declaredProperties.firstOrNull { it.name == property.name } ?:
                throw QMLRuntimeException("Property value set multiple times"))

    }

    override fun connect(propertyName: String, slot: () -> Unit) {
        val prop = getProperty(propertyName) ?: throw QMLRuntimeException("Property $propertyName not found")
        prop.signal.connect(slot)
    }

    override fun disconnect(propertyName: String, slot: () -> Unit) {
        val prop = getProperty(propertyName) ?: throw QMLRuntimeException("Property $propertyName not found")
        prop.signal.disconnect(slot)
    }

    override fun getProperty(name: String): QMLProperty? {
        return declaredProperties.firstOrNull { it.name == name }
    }

    override fun addChild(child: QMLObject) {
        if (this.children.contains(child)) {
            return
        }
        this.children.add(child)
    }

    override fun removeChild(child: QMLObject) {
        this.children.remove(child)
    }
}
