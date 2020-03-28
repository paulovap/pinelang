package com.pinescript.ast

import com.pinescript.core.*
import com.pinescript.parser.PineScriptParser

class ExpressionVisitor(
    engine: PineEngine,
    rootContext: PineContext,
    var owner: PineObject
) : PineScriptVisitor<PineValue<*>>(engine, rootContext) {

    override fun visitExpression(context: PineScriptParser.ExpressionContext?): PineValue<*> {
        val ctx = context!!

        ctx.primitiveExpression()?.also { return visit(ctx.primitiveExpression()) }

        ctx.binaryOperation()
            ?.also { return PineBinaryExprValue(it.getOp(), visit(ctx.expression(0)), visit(ctx.expression(1))) }

        ctx.objectPropertyExpression()?.also { return findProp(owner, it.Identifier()).value }

        throw PineScriptParseException(ctx.start, "expression not recognized")
    }

    override fun visitCallableExpression(ctx: PineScriptParser.CallableExpressionContext?): ExprValue<*> {
        val name = ctx!!.Identifier().text
        return owner.callables[name] ?: throw PineScriptParseException(
            ctx.LPAREN(),
            "Object $owner does not have a callable $name"
        )
    }

    override fun visitPrimitiveExpression(ctx: PineScriptParser.PrimitiveExpressionContext?): PineValue<*> {
        return when {
            ctx!!.TRUE() != null -> true.toPineValue()
            ctx.FALSE() != null -> false.toPineValue()
            ctx.StringLiteral() != null -> ctx.StringLiteral().text.removeQuotes().toPineValue()
            ctx.IntegerLiteral() != null -> ctx.IntegerLiteral().text.toInt().dp(ctx.integerSuffix() != null)
                .toPineValue()
            ctx.FloatLiteral() != null -> ctx.FloatLiteral().text.toDouble().toPineValue()
            else -> throw PineScriptParseException(ctx.start, "failed to parse primitive expression")
        }
    }

    private fun Int.dp(shouldApply: Boolean): Int = engine.dpCalculator(this)
    private fun String.removeQuotes(): String = substring(1 until this.length - 1)

    private fun PineScriptParser.BinaryOperationContext.getOp(): BinaryOp {
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