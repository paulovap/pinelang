/*
BSD License

Copyright (c) 2020, Paulo Pinheiro
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

import org.pinelang.ast.fbs.ObjectDefinition
import org.pinelang.ast.fbs.ObjectDefinition.Companion.createChildrenVector
import org.pinelang.ast.fbs.ObjectDefinition.Companion.createPropsVector
import org.pinelang.ast.fbs.ObjectDefinition.Companion.createSignalsVector
import org.pinelang.ast.fbs.SignalExpr
import org.pinelang.core.PineCompiler
import org.pinelang.parser.PineScript

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

class ObjectDefinitionVisitor(compiler: PineCompiler, debug: Boolean) :
    PineScriptVisitor<Int>(compiler, debug) {

  private val propertyVisitor = PropertyVisitor(compiler, -1, -1, debug)
  private val expressionVisitor = ExpressionVisitor(compiler, -1, -1, debug)

  override fun visitObjectDefinition(ctx: PineScript.ObjectDefinitionContext): Int {
    val initContext = ctx.objectInitializer()
    val objIdentifierCtx = initContext.objectIdentifier()

    // Object information
    val nameType = ctx.ObjectType().text
    val typeIdx =
        types.getIndexOrNull(nameType)
            ?: ctx.ObjectType().throwParseException("Type $nameType not found engine")
    val type = types[typeIdx]!!
    val debugName = objIdentifierCtx?.Identifier()?.text ?: ""
    val objId = compiler.generateObjectId(typeIdx, debugName)

    val children: MutableList<Int> = ArrayList()
    val signals: MutableList<Int> = ArrayList()
    val props: MutableList<Int> = ArrayList()

    for (objDefinition in initContext.objectDefinition()) {
      children.add(visit(objDefinition))
    }

    for (propertyDefinition in initContext.propertyDefinition()) {
      props.add(propertyVisitor.reset(typeIdx, objId).visit(propertyDefinition))
    }

    for (signal in initContext.signalAssignement()) {
      val name = signal.Identifier().text
      val id = type.indexOfSignal(name)
      val expr = expressionVisitor.reset(typeIdx, objId).visit(signal.callableExpression())
      signals.add(
          run {
            val debugInfo: Int? = if (debug) createDebugInfo(signal, name, "signalExp") else null
            SignalExpr.startSignalExpr(fb)
            SignalExpr.addId(fb, id!!.toUByte())
            SignalExpr.addExpr(fb, expr)
            debugInfo?.run { SignalExpr.addDebug(fb, debugInfo) }
            SignalExpr.endSignalExpr(fb)
          })
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
