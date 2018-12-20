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
package com.flex.core

import java.util.HashMap
import kotlin.reflect.KClass

class QMLEngine private constructor(private var namespaces: LinkedHashMap<String, HashMap<String, KClass<*>>>) {

    private var compiler: QMLCompiler = QMLCompiler(this)
    val rootContext = QMLContext(null)

    fun load(script: String): QMLObject {
        return compiler.compile(script)
    }

    fun getKClass(qmlType: String): KClass<*>? {
        for (name in namespaces.keys) {
            if (namespaces[name]!!.containsKey(qmlType)) {
                return namespaces[name]!![qmlType]
            }
        }
        return null
    }


    class Builder {
        private val namespaces = LinkedHashMap<String, HashMap<String, KClass<*>>>()

        init {
            // @TODO: For conversion reasons, ints always have to be Longs in QML.
            // The reason for this is Number.parse() returns Long for integers
            // Don't know best approach yet
            namespaces[""] = HashMap()
            namespaces[""]!!["int"] = Long::class
            namespaces[""]!!["long"] = Long::class
            namespaces[""]!!["double"] = Double::class
            namespaces[""]!!["real"] = Double::class
            namespaces[""]!!["string"] = String::class
            namespaces[""]!!["bool"] = Boolean::class
            namespaces[""]!!["var"] = QtObject::class
            namespaces[""]!!["QtObject"] = QtObject::class
        }

        fun registerQMLType(namespace: String, typeName: String, clazz: KClass<out QMLObject>): Builder {
            namespaces[namespace] = namespaces[namespace] ?: HashMap()
            namespaces[namespace]!![typeName] = clazz
            return this
        }

        fun build(): QMLEngine {
            return QMLEngine(namespaces)
        }
    }
}
