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

package com.pinescript.ast

import com.pinescript.ast.fbs.ObjectDefinition
import com.pinescript.ast.fbs.SignalExpr
import com.pinescript.core.*
import com.pinescript.parser.PineScriptParser

/*
table ObjectDefinition {
    debugName: string;
    type:      int32;
    debugId:   string;
    id:        int64;
    children:  [ObjectDefinition];
    signals:   [SignalAssignment];
    props:     [Prop];
}
 */

class ObjectDefinitionVisitor(engine: PineEngine) : PineScriptVisitor<Int>(engine) {

    override fun visitObjectDefinition(ctx: PineScriptParser.ObjectDefinitionContext): Int {
        val rootContext = engine.rootContext
        val fb = engine.compiler.flatBuilder
        val initContext = ctx.objectInitializer()
        val objIdentifierCtx = initContext.objectIdentifier()
        val objMember = initContext.objectMember()


        // Object information
        val nameType = ctx.ObjectType().text
        val typeIdx = engine.types.getIndexOrNull(nameType) ?: ctx.ObjectType()
            .throwParseException("Type $nameType not found engine")
        val type = engine.types[typeIdx]!!
        val debugName = objIdentifierCtx?.Identifier()?.text ?: ""
        val objId = engine.compiler.generateObjectId(typeIdx, debugName)
        val children: MutableList<Int> = mutableListOf()
        val signals: MutableList<Int> = mutableListOf()
        val props: MutableList<Int> = mutableListOf()

        objMember.forEach {

            /* Children parsing */
            if (it.objectDefinition() != null) {
                children.add(ObjectDefinitionVisitor(engine).visit(it.objectDefinition()))
            }

            /* assigning script to a declared property */
            if (it.propertyAssignement() != null) {
                props.add(PropertyVisitor(engine, typeIdx, objId).visit(it.propertyAssignement()))
            }

            /*
                table SignalAssignment {
                    debugName:     string;
                    id:            ubyte;
                    expr:          CallableExpr;
                }
             */
            it.signalAssignement()?.also { sigCtx ->
                val name = sigCtx.Identifier().text
                val id = type.signalIndexes[name] ?: sigCtx.Identifier().throwParseException("signal $name not found")
                val expr = ExpressionVisitor(engine, typeIdx, objId).visit(sigCtx.callableExpression())
                signals.add(SignalExpr.createSignalExpr(fb, id, expr.first, expr.second))
            }
        }

        val childrenVec = ObjectDefinition.createChildrenVector(fb, children.toIntArray())
        val propVec = ObjectDefinition.createChildrenVector(fb, props.toIntArray())
        val signalVec = ObjectDefinition.createChildrenVector(fb, signals.toIntArray())
        return ObjectDefinition.createObjectDefinition(
            fb,
            fb.createString(nameType),
            typeIdx,
            fb.createString(debugName),
            objId,
            childrenVec,
            signalVec,
            propVec
        )
    }
}
