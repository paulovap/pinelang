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

import com.pinescript.ast.fbs.Prop
import com.pinescript.ast.fbs.PropType
import com.pinescript.core.*
import com.pinescript.parser.PineScriptParser

/*
table Prop {
    debugName: string;
    idx:       byte;
    type:      PropType;
    value:     Expr;
}
 */
@ExperimentalUnsignedTypes
class PropertyVisitor(engine: PineEngine, val ownerType: Int, val ownerId: Long) : PineScriptVisitor<Int>(engine) {

    override fun visitPropertyAssignement(ctx: PineScriptParser.PropertyAssignementContext?): Int {
        val fb = engine.compiler.flatBuilder
        val propName = ctx!!.Identifier().text
        val propIdx = engine.types[ownerType]?.propIndexes?.get(propName!!) ?: ctx.Identifier().throwPropNotFound(propName, "this")

        Prop.startProp(engine.compiler.flatBuilder)
        Prop.addDebugName(fb, fb.createString(propName))
        Prop.addIdx(fb, propIdx.toUByte())
        Prop.addType(fb, PropType.Boolean)
        val (valueType, value) = ExpressionVisitor(engine, ownerType, ownerId).visit(ctx.expression()!!)
        Prop.addValue(fb, value)
        Prop.addValueType(fb, valueType.toUByte())
        return Prop.endProp(engine.compiler.flatBuilder)
    }
//    override fun visitPropertyAssignement(ctx: PineScriptParser.PropertyAssignementContext?) {
//        val propName = ctx!!.Identifier().text
//        val prop = owner.getProp(propName) ?: ctx.Identifier().throwPropNotFound(propName, "this")
//
//        ctx.expression()?.let { exprCtx ->
//
//            exprCtx.primitiveExpression()?.let { prop.setPineValue(ExpressionVisitor(engine, rootContext, owner).visit(it)) }
//
//            exprCtx.objectPropertyExpression()?.let { prop.bind(findProp(owner, it.Identifier())) }
//
//            exprCtx.binaryOperation()?.let { prop.setPineValue(ExpressionVisitor(engine, rootContext, owner).visit(exprCtx)) }
//
//            exprCtx.callableExpression()?.let { prop.setPineValue(ExpressionVisitor(engine, rootContext, owner).visit(it)) }
//        }
//    }
}
