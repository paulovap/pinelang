package com.pinescript.ast

import com.pinescript.ast.fbs.*
import com.pinescript.ast.fbs.BinaryOp
import com.pinescript.ast.fbs.PrimitiveExpr.Companion.createPrimitiveExpr
import com.pinescript.core.*
import com.pinescript.parser.PineScriptParser

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
class ExpressionVisitor(engine: PineEngine, val ownerType: Int, val ownerId: Long) :
    PineScriptVisitor<Pair<UByte, Int>>(engine) {

    override fun visitExpression(context: PineScriptParser.ExpressionContext?): Pair<UByte, Int> {
        val ctx = context!!

        val primitiveExpr = ctx.primitiveExpression()
        val binaryOp = ctx.binaryOperation()
        val objPropExpr = ctx.objectPropertyExpression()
        return when {
            primitiveExpr != null -> visit(ctx.primitiveExpression())
            binaryOp != null -> createBinaryOperationExp(binaryOp, ctx.expression(0), ctx.expression(1))
            objPropExpr != null -> createPropExpr(objPropExpr)
            else -> throw PineScriptParseException(ctx.start, "expression not recognized")
        }
    }

    private fun createPropExpr(ctx: PineScriptParser.ObjectPropertyExpressionContext): Pair<UByte, Int> {
        val fb = engine.compiler.flatBuilder
        val ids = ctx.Identifier()
        return Pair(
            Expr.PropExpr,
            if (ids.size == 1) {
                val propId =
                    engine.types[ownerType]!!.propIndexes[ids[0].text] ?: ids[0].throwPropNotFound(ids[0].text, "this")
                PropExpr.createPropExpr(fb, ownerId, propId.toUByte())
            } else {
                val objName = ids[0].text!!
                val propName = ids[1].text!!
                val objMeta = engine.compiler.objectMetaData(objName) ?: ids[0].throwObjNotFound(ids[0].text)
                val objType = engine.types[objMeta.typeIdx]!!
                val propIdx = objType.propIndexes[propName] ?: ids[1].throwPropNotFound(ids[1].text, ids[0].text)
                PropExpr.createPropExpr(fb, ownerId, propIdx.toUByte())
            }
        )
    }

    /*
    table BinaryExpr {
    op: int64;
    left: Expr;
    right: Expr;
    }
     */
    private fun createBinaryOperationExp(
        opCtx: PineScriptParser.BinaryOperationContext,
        left: PineScriptParser.ExpressionContext,
        right: PineScriptParser.ExpressionContext
    ): Pair<UByte, Int> {
        val fb = engine.compiler.flatBuilder
        val (leftType, leftValue) = visit(left)
        val (rightType, rightValue) = visit(right)
        return Pair(
            Expr.BinaryExpr,
            BinaryExpr.createBinaryExpr(fb, opCtx.getOp(), leftType, leftValue, rightType, rightValue)
        )
    }

    /*
    table CallableExpr {
        objId: int64;
        callIdx: ubyte;
     }
     */
    override fun visitCallableExpression(ctx: PineScriptParser.CallableExpressionContext?): Pair<UByte, Int> {
        val fb = engine.compiler.flatBuilder
        val name = ctx!!.Identifier().text
        val callIdx =
            engine.types[ownerType]!!.callableIndexes[name] ?: ctx.Identifier().throwCallableNotFound(name, "this")
        return Pair(Expr.CallableExpr, CallableExpr.createCallableExpr(fb, ownerId, callIdx.toUByte()))
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
    override fun visitPrimitiveExpression(ctx: PineScriptParser.PrimitiveExpressionContext?): Pair<UByte, Int> {
        val fb = engine.compiler.flatBuilder
        val exprType = Expr.PrimitiveExpr
        val exprVal = when {
            ctx!!.TRUE() != null -> createPrimitiveExpr(fb, PrimitiveType.Boolean, 0.toUByte(), 0, 0.0, 0)
            ctx.FALSE() != null -> createPrimitiveExpr(fb, PrimitiveType.Boolean, 1.toUByte(), 0, 0.0, 0)
            ctx.StringLiteral() != null -> createPrimitiveExpr(
                fb,
                PrimitiveType.String,
                0.toUByte(),
                0,
                0.0,
                fb.createString(ctx.StringLiteral().text.removeQuotes())
            )
            ctx.IntegerLiteral() != null -> createPrimitiveExpr(
                fb,
                PrimitiveType.Int,
                0.toUByte(),
                ctx.IntegerLiteral().text.toInt().dp(ctx.integerSuffix() != null),
                0.0,
                0
            )
            ctx.FloatLiteral() != null -> createPrimitiveExpr(
                fb,
                PrimitiveType.Boolean,
                0.toUByte(),
                0,
                ctx.FloatLiteral().text.toDouble(),
                0
            )
            else -> throw PineScriptParseException(ctx.start, "failed to parse primitive expression")
        }
        return Pair(exprType, exprVal)
    }

    private fun Int.dp(shouldApply: Boolean): Int = engine.dpCalculator(this)
    private fun String.removeQuotes(): String = substring(1 until this.length - 1)

    private fun PineScriptParser.BinaryOperationContext.getOp(): UByte {
        return when {
            this.PLUS() != null -> BinaryOp.PLUS
            this.MINUS() != null -> BinaryOp.MINUS
            this.MULTI() != null -> BinaryOp.MULTI
            this.DIV() != null -> BinaryOp.DIV
            this.REMAINDER() != null -> BinaryOp.REMAINDER
            this.AND() != null -> BinaryOp.AND
            this.OR() != null -> BinaryOp.OR
            else -> throw PineScriptException("operator $this not recognized")
        }
    }
}