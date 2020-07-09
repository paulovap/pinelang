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

import org.pinelang.ast.fbs.BinaryExpr
import org.pinelang.ast.fbs.BinaryOp
import org.pinelang.ast.fbs.CallableExpr
import org.pinelang.ast.fbs.Expr
import org.pinelang.ast.fbs.ExprValue
import org.pinelang.ast.fbs.PrimitiveExpr.Companion.createPrimitiveExpr
import org.pinelang.ast.fbs.PrimitiveType
import org.pinelang.ast.fbs.PropRefExpr
import org.pinelang.core.PineCompiler
import org.pinelang.core.PineScriptParseException
import org.pinelang.parser.PineScript

/*
table CallableExpr {
    objId: int64;
    callIdx: byte;
}

enum BinaryOp : byte {
    PLUS = 0,
    MINUS,
    MULTI,
    DIV,
    REMAINDER,
    AND,
    OR
}
table BinaryExpr {
    op: int64;
    callIdx: byte;
}

enum PrimitiveType : byte {
    Int = 0,
    Double,
    String,
    Boolean,
    ObjectProperty
}

table PrimitiveExpr {
    type: PrimitiveType;
    boolValue:     byte;
    intValue:      int32;
    doubleValue:   float64;
    stringValue:   string;
}

union Expr {CallableExpr, BinaryExpr, PrimitiveExpr}
 */
@ExperimentalUnsignedTypes
class ExpressionVisitor(
    compiler: PineCompiler, var ownerType: Int, var ownerId: Int, debug: Boolean
) : PineScriptVisitor<Int>(compiler, debug) {

  fun reset(ownerType: Int, ownerId: Int): ExpressionVisitor {
    this.ownerType = ownerType
    this.ownerId = ownerId
    return this
  }

  override fun visitExpression(context: PineScript.ExpressionContext?): Int {
    val ctx = context!!

    val primitiveExpr = ctx.primitiveExpression()
    val binaryOp = ctx.binaryOperation()
    val objPropExpr = ctx.objectPropertyExpression()
    val callExpr = ctx.callableExpression()
    return when {
      primitiveExpr != null ->
          Expr.createExpr(fb, ExprValue.PrimitiveExpr, visit(ctx.primitiveExpression()))
      binaryOp != null ->
          Expr.createExpr(
              fb,
              ExprValue.BinaryExpr,
              createBinaryOperationExp(binaryOp, ctx.expression(0), ctx.expression(1)))
      objPropExpr != null -> Expr.createExpr(fb, ExprValue.PropRefExpr, createPropExpr(objPropExpr))
      callExpr != null ->
          Expr.createExpr(fb, ExprValue.CallableExpr, visitCallableExpression(callExpr))
      else -> throw PineScriptParseException(ctx.start, ctx.stop, "expression not recognized")
    }
  }

  private fun createPropExpr(ctx: PineScript.ObjectPropertyExpressionContext): Int {
    val ids = ctx.Identifier()
    return if (ids.size == 1) {
      val propId = types[ownerType]!!.indexOfProp(ids[0].text)!!
      PropRefExpr.createPropRefExpr(fb, ownerId, propId.toUByte())
    } else {
      val objName = ids[0].text!!
      val propName = ids[1].text!!
      val objMeta = compiler.objectMetaData(objName) ?: ctx.throwObjNotFound(ids[0].text)
      val objType = types[objMeta.typeIdx]!!
      val propIdx = objType.indexOfProp(propName)
      PropRefExpr.createPropRefExpr(fb, objMeta.objId, propIdx!!.toUByte())
    }
  }

  /*
  table BinaryExpr {
  op: int64;
  left: Expr;
  right: Expr;
  }
   */
  private fun createBinaryOperationExp(
      opCtx: PineScript.BinaryOperationContext,
      left: PineScript.ExpressionContext,
      right: PineScript.ExpressionContext
  ): Int {
    val leftIdx = visit(left)
    val rightIdx = visit(right)
    return BinaryExpr.createBinaryExpr(fb, opCtx.getOp(), leftIdx, rightIdx)
  }

  override fun visitCallableExpression(ctx: PineScript.CallableExpressionContext?): Int {
    val name = ctx!!.Identifier().text
    val callIdx =
        types[ownerType]!!.indexOfCallable(name) ?: ctx.throwCallableNotFound(name, "this")
    return CallableExpr.createCallableExpr(fb, ownerId, callIdx.toUByte())
  }

  /*
     table PrimitiveExpr {
         type: PrimitiveType;
         boolValue:     byte;
         intValue:      int32;
         doubleValue:   float64;
         stringValue:   string;
     }
  */

  override fun visitPrimitiveExpression(ctx: PineScript.PrimitiveExpressionContext?): Int {
    return when {
      ctx!!.TRUE() != null -> createPrimitiveExpr(fb, PrimitiveType.Boolean, 1.0, 0)
      ctx.FALSE() != null -> createPrimitiveExpr(fb, PrimitiveType.Boolean, 0.0, 0)
      ctx.stringLiteral() != null -> {
        val strIdx = fb.createString(ctx.stringLiteral().STRING().text)
        createPrimitiveExpr(fb, PrimitiveType.String, 0.0, strIdx)
      }
      ctx.IntegerLiteral() != null ->
          createPrimitiveExpr(
              fb,
              PrimitiveType.Int,
              ctx.IntegerLiteral().text.toInt().dp(ctx.integerSuffix() != null).toDouble(),
              0)
      ctx.FloatLiteral() != null ->
          createPrimitiveExpr(fb, PrimitiveType.Double, ctx.FloatLiteral().text.toDouble(), 0)
      else ->
          throw PineScriptParseException(
              ctx.start, ctx.stop, "failed to parse primitive expression")
    }
  }

  private fun Int.dp(shouldApply: Boolean): Int = this
  private fun String.removeQuotes(): String = substring(1 until this.length - 1)

  private fun PineScript.BinaryOperationContext.getOp(): UByte {
    return when {
      this.PLUS() != null -> BinaryOp.PLUS
      this.MINUS() != null -> BinaryOp.MINUS
      this.MULTI() != null -> BinaryOp.MULTI
      this.DIV() != null -> BinaryOp.DIV
      this.REMAINDER() != null -> BinaryOp.REMAINDER
      this.AND() != null -> BinaryOp.AND
      this.OR() != null -> BinaryOp.OR
      else -> throw PineScriptParseException(this.start, this.stop, "operator $this not recognized")
    }
  }
}
