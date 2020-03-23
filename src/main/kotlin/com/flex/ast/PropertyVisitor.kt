package com.flex.ast

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

import com.flex.ast.expression.FunctionExpressionVisitor
import com.flex.ast.expression.PrimaryExpressionVisitor
import com.flex.core.*
import com.flex.parser.PineScriptParser
import org.antlr.v4.runtime.tree.TerminalNode

class PropertyVisitor(engine: PineEngine, var rootContext: PineContext, var owner: PineObject) :
    PineScriptVisitor<Unit>(engine) {

    override fun visitPropertyAssignement(ctx: PineScriptParser.PropertyAssignementContext?) {
        val leftSidePropName = ctx!!.Identifier().text
        val prop =
            owner.getProp(leftSidePropName) ?: ctx.Identifier().throwPropNotFound(leftSidePropName, "this")

        ctx.expression()?.also {

            it.primitiveExpression()?.also { primitiveExp -> prop.setPineValue(PrimaryExpressionVisitor().visit(primitiveExp)) }

            it.objectPropertyExpression()?.also { propExp ->
                val ids = propExp.Identifier()
                if (ids.size == 1) {
                    // this means we are referring a local property
                    val rightSidePropName = ids[0].text
                    val rightProp = owner.getProp(rightSidePropName) ?: ids[0].throwPropNotFound(rightSidePropName, "this")
                    prop.checkType(ctx.Identifier(), rightProp)
                    prop.bind(rightProp)
                } else {
                    val rightSideObjName = ids[0].text
                    val rightSizePropName = ids[1].text
                    val otherObject =
                        rootContext.find(rightSideObjName) ?: ctx.Identifier().throwObjNotFound(rightSideObjName)
                    val rightProp = otherObject.getProp(rightSizePropName) ?: ctx.Identifier().throwPropNotFound(rightSizePropName, rightSideObjName)
                    prop.checkType(ctx.Identifier(), rightProp)
                    prop.bind(rightProp)
                }
            }

            it.binaryOperation()?.also { fCtx ->
                //prop.checkType(fCtx, leftExp)
                prop.setPineValue(ExpressionVisitor(engine,rootContext, owner, prop).visit(it))
            }
        }
    }

    private fun TerminalNode.throwPropNotFound(propName: String, objName: String): Nothing {
        throw PineScriptParseException(this, "prop $propName on object $objName not found")
    }

    private fun TerminalNode.throwObjNotFound(objName: String): Nothing {
        throw PineScriptParseException(this, "object with identifier $objName not found")
    }

    private fun PineProp<*>.checkType(node: TerminalNode, other: PineProp<*>) {
        if (other.pineType != this.pineType)
            throw PineScriptParseException(node, "unable to cast type ${other.pineType} to ${this.pineType}")
    }
}
