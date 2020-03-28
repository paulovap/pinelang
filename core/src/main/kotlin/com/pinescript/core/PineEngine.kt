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
package com.pinescript.core

import java.util.HashMap

// id, parent, children, properties
typealias ObjectAllocator = (Long) -> PineObject

class PineEngine private constructor(
    val types: HashMap<String, ObjectAllocator>,

    val dpCalculator: (Int) -> Int) {

    private var compiler: PineCompiler = PineCompiler(this)

    fun load(script: String): PineObject {
        return compiler.compile(script)
    }

    fun getAllocator(qmlType: String): ObjectAllocator {
        return types[qmlType]?: throw PineScriptException("Allocator of type $qmlType not found")
    }

    class Builder {
        private val types = HashMap<String, ObjectAllocator>()
        private var dpCalc: (Int) -> Int = { it }
        init {
            // @TODO: For conversion reasons, ints always have to be Longs in QML.
            // The reason for this is Number.parse() returns Long for integers
            // Don't know best approach yet
            types["var"] = { id -> PineObject(id)}
            types["Object"] = { id -> PineObject(id)}
        }

        fun registerQMLType(typeName: String, allocator: ObjectAllocator): Builder {
            types[typeName] = allocator
            return this
        }

        fun pixelDensityCalculator(lambda: (Int) -> Int) {
            this.dpCalc = lambda
        }

        fun build(): PineEngine {
            return PineEngine(types, dpCalc)
        }
    }
}
