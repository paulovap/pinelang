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

import org.pinelang.ast.fbs.PropDefinition
import org.pinelang.core.PineCompiler
import org.pinelang.parser.PineScript

/*
table Prop {
    debugName: string;
    idx:       byte;
    type:      PropType;
    value:     Expr;
}
 */
@ExperimentalUnsignedTypes
class PropertyVisitor(
    compiler: PineCompiler, var ownerType: Int, var ownerId: Int, debug: Boolean
) : PineScriptVisitor<Int>(compiler, debug) {

  val expressionVisitor = ExpressionVisitor(compiler, ownerType, ownerId, debug)

  fun reset(ownerType: Int, ownerId: Int): PropertyVisitor {
    this.ownerType = ownerType
    this.ownerId = ownerId
    expressionVisitor.reset(ownerType, ownerId)
    return this
  }

  override fun visitPropertyDefinition(ctx: PineScript.PropertyDefinitionContext?): Int {
    val propName = ctx!!.Identifier().text
    val propId =
        types[ownerType]?.indexOfProp(propName!!)
            ?: ctx.throwPropNotFound(propName, types[ownerType]!!.scriptName)

    val exprValue = expressionVisitor.reset(ownerType, ownerId).visit(ctx.expression()!!)

    val debugInfo = if (debug) createDebugInfo(ctx, propName, "PropertyDefinition") else null
    PropDefinition.startPropDefinition(fb)
    PropDefinition.addId(fb, propId.toUByte())
    PropDefinition.addValue(fb, exprValue)
    debugInfo?.run { PropDefinition.addDebug(fb, debugInfo) }
    return PropDefinition.endPropDefinition(fb)
  }
}
