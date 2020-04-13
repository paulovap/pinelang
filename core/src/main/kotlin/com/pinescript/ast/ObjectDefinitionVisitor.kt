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
import com.pinescript.ast.fbs.ObjectDefinition.Companion.createChildrenVector
import com.pinescript.ast.fbs.ObjectDefinition.Companion.createPropsVector
import com.pinescript.ast.fbs.ObjectDefinition.Companion.createSignalsVector
import com.pinescript.ast.fbs.SignalExpr
import com.pinescript.core.*
import com.pinescript.parser.PineScript

/*
table ObjectDefinition {
    id:        int32;
    type:      int32;
    children:  [ObjectDefinition];
    signals:   [SignalExpr];
    props:     [Prop];
    debugName: string;
    debugType: string;
}
 */

class ObjectDefinitionVisitor(compiler: PineCompiler, debug: Boolean) : PineScriptVisitor<Int>(compiler, debug) {

    private val propertyVisitor = PropertyVisitor(compiler, -1, -1, debug)
    private val expressionVisitor = ExpressionVisitor(compiler, -1, -1, debug)

    override fun visitObjectDefinition(ctx: PineScript.ObjectDefinitionContext): Int {
        val initContext = ctx.objectInitializer()
        val objIdentifierCtx = initContext.objectIdentifier()
        val objMember = initContext.objectMember()


        // Object information
        val nameType = ctx.ObjectType().text
        val typeIdx = types.getIndexOrNull(nameType) ?: ctx.ObjectType()
            .throwParseException("Type $nameType not found engine")
        val type = types[typeIdx]!!
        val debugName = objIdentifierCtx?.Identifier()?.text ?: ""
        val objId = compiler.generateObjectId(typeIdx, debugName)
        val children: MutableList<Int> = ArrayList(16)
        val signals: MutableList<Int> = ArrayList(16)
        val props: MutableList<Int> = ArrayList(16)

        for (i in 0 until objMember.size) {
            val it = objMember[i]

            /* Children parsing */
            if (it.objectDefinition() != null) {
                children.add(visit(it.objectDefinition()))
            }

            /* assigning script to a declared property */
            if (it.propertyDefinition() != null) {
                props.add(propertyVisitor.reset(typeIdx, objId).visit(it.propertyDefinition()))
            }

            /*
            table SignalAssignment {
                id:            ubyte;
                expr:          CallableExpr;
                debugName:     string;
            }
         */
            it.signalAssignement()?.also { sigCtx ->
                val name = sigCtx.Identifier().text
                val id =
                    type.indexOfSignal(name)
                val expr = expressionVisitor.reset(typeIdx, objId).visit(sigCtx.callableExpression())
                signals.add(run {
                    val debugInfo: Int? = if (debug) createDebugInfo(sigCtx, name, "signalExp") else null
                    SignalExpr.startSignalExpr(fb)
                    SignalExpr.addId(fb, id.toUByte())
                    SignalExpr.addExpr(fb, expr)
                    debugInfo?.run { SignalExpr.addDebug(fb, debugInfo) }
                    SignalExpr.endSignalExpr(fb)
                })
            }
        }


        val debugInfo = if (debug) createDebugInfo(ctx, debugName, nameType) else null

        val childrenVec = if (children.size > 0) createChildrenVector(fb, children.toIntArray()) else -1
        val propVec = if (props.size > 0) createPropsVector(fb, props.toIntArray()) else -1
        val signalVec = if (signals.size > 0) createSignalsVector(fb, signals.toIntArray()) else -1

        ObjectDefinition.startObjectDefinition(fb)
        ObjectDefinition.addId(fb, objId)
        ObjectDefinition.addType(fb, typeIdx)

        if (childrenVec != -1) ObjectDefinition.addChildren(fb, childrenVec)
        if (propVec != -1) ObjectDefinition.addProps(fb, propVec)
        if (signalVec != -1) ObjectDefinition.addSignals(fb, signalVec)
        debugInfo?.run { ObjectDefinition.addDebug(fb, debugInfo) }

        return ObjectDefinition.endObjectDefinition(fb)
    }
}
