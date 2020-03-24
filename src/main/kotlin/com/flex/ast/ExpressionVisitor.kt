package com.flex.ast

import com.flex.ast.expression.PrimaryExpressionVisitor
import com.flex.core.*
import com.flex.parser.PineScriptParser
import org.antlr.v4.runtime.tree.TerminalNode

class ExpressionVisitor(engine: PineEngine, var rootContext: PineContext, var owner: PineObject, var pineProp: PineProp<*>) : PineScriptVisitor<PineValue<*>>(engine) {
    override fun visitExpression(ctx: PineScriptParser.ExpressionContext?): PineValue<*> {
        if (ctx?.primitiveExpression() != null)
            return PrimaryExpressionVisitor().visit(ctx.primitiveExpression())

        if (ctx?.binaryOperation() != null) {
            val leftExp:PineValue<*> = visit(ctx.expression(0))
            val rightExp:PineValue<*> = visit(ctx.expression(1))
            return PineBinaryOperationExpressionValue(ctx.binaryOperation().getOp(), leftExp, rightExp)
        }

        if (ctx?.objectPropertyExpression() != null) {
            val objectPropCtx = ctx.objectPropertyExpression()
            val ids = objectPropCtx.Identifier()
            return if (ids.size == 1) {
                // this means we are referring a local property
                val rightSidePropName = ids[0].text
                val rightProp = owner.getProp(rightSidePropName) ?: ids[0].throwPropNotFound(rightSidePropName, "this")
                rightProp.value
            } else {
                val rightSideObjName = ids[0].text
                val rightSizePropName = ids[1].text
                val otherObject =
                    rootContext.find(rightSideObjName) ?: objectPropCtx.Identifier(0).throwObjNotFound(rightSideObjName)
                val rightProp = otherObject.getProp(rightSizePropName) ?: objectPropCtx.Identifier(0).throwPropNotFound(rightSizePropName, rightSideObjName)
                rightProp.value
            }
        }
        return PineValue.of(null)
    }



    private fun PineScriptParser.BinaryOperationContext.getOp(): BinaryOperations {
        if (this.PLUS() != null) return BinaryOperations.PLUS
        if (this.MINUS() != null) return BinaryOperations.MINUS
        if (this.MULTI() != null) return BinaryOperations.MULTI
        if (this.DIV() != null) return BinaryOperations.DIV
        if (this.REMAINDER() != null) return BinaryOperations.REMAINDER
        if (this.AND() != null) return BinaryOperations.AND
        if (this.OR() != null) return BinaryOperations.OR
        throw PineScriptException("operator $this not recognized")
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