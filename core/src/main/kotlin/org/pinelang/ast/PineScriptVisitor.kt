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

package org.pinelang.ast

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.TerminalNode
import org.pinelang.ast.fbs.DebugInfo
import org.pinelang.ast.fbs.Range
import org.pinelang.core.PineCompiler
import org.pinelang.core.PineScriptParseException
import org.pinelang.parser.PineScriptBaseVisitor

open class PineScriptVisitor<T>(protected var compiler: PineCompiler, var debug: Boolean) :
    PineScriptBaseVisitor<T>() {

    val types = compiler.types
    val fb = compiler.flatBuilder

    fun ParserRuleContext.throwPropNotFound(propName: String, objName: String): Nothing {
        throw PineScriptParseException(
            this.start,
            this.stop,
            "prop $propName on object $objName not found"
        )
    }

    fun ParserRuleContext.throwCallableNotFound(callableName: String, objName: String): Nothing {
        throw PineScriptParseException(
            this.start,
            this.stop,
            "callable $callableName on object $objName not found"
        )
    }

    fun ParserRuleContext.throwObjNotFound(objName: String): Nothing {
        throw PineScriptParseException(
            this.start,
            this.stop,
            "object with identifier $objName not found"
        )
    }

    fun ParserRuleContext.throwParseException(msg: String): Nothing {
        throw PineScriptParseException(
            this.start,
            this.stop,
            msg
        )
    }

    fun TerminalNode.throwParseException(msg: String): Nothing {
        throw PineScriptParseException(
            this.symbol.line,
            this.symbol.startIndex,
            this.symbol.line,
            this.symbol.stopIndex,
            msg
        )
    }

    fun createDebugInfo(
        startNode: TerminalNode,
        endNode: TerminalNode,
        name: String?,
        type: String?
    ): Int =
        createDebugInfo(startNode.symbol, endNode.symbol, name, type)

    fun createDebugInfo(ctx: ParserRuleContext, name: String?, type: String?): Int =
        createDebugInfo(ctx.start, ctx.stop, name, type)

    fun createDebugInfo(startToken: Token, endToken: Token, name: String?, type: String?): Int {

        val namePos: Int? = name?.run { fb.createString(name) }
        val typePos: Int? = type?.run { fb.createString(type) }
        DebugInfo.startDebugInfo(fb)
        DebugInfo.addRange(
            fb, Range.createRange(
                fb,
                startToken.line,
                startToken.charPositionInLine,
                endToken.line,
                endToken.charPositionInLine
            )
        )
        namePos?.run { DebugInfo.addDebugName(fb, namePos) }
        typePos?.run { DebugInfo.addDebugType(fb, typePos) }
        return DebugInfo.endDebugInfo(fb)
    }
}
