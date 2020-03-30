package com.pinescript.ast

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

import com.pinescript.core.PineCompiler
import com.pinescript.core.PineScriptParseException
import com.pinescript.parser.PineScriptBaseVisitor
import org.antlr.v4.runtime.tree.TerminalNode

open class PineScriptVisitor<T>(protected var compiler: PineCompiler, var debug: Boolean) : PineScriptBaseVisitor<T>() {

    val types = compiler.types
    val fb = compiler.flatBuilder

    fun TerminalNode.throwPropNotFound(propName: String, objName: String): Nothing {
        throw PineScriptParseException(this, "prop $propName on object $objName not found")
    }

    fun TerminalNode.throwCallableNotFound(callableName: String, objName: String): Nothing {
        throw PineScriptParseException(this, "callable $callableName on object $objName not found")
    }

    fun TerminalNode.throwObjNotFound(objName: String): Nothing {
        throw PineScriptParseException(this, "object with identifier $objName not found")
    }

    fun TerminalNode.throwParseException(msg: String): Nothing {
        throw PineScriptParseException(this, msg)
    }

}
