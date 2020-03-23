package com.flex.ast.expression

import com.flex.core.PineObject
import com.flex.core.PineProp
import com.flex.parser.PineScriptBaseVisitor
import com.flex.parser.PineScriptParser

class FunctionExpressionVisitor (private val prop: PineProp<*>, val owner: PineObject): PineScriptBaseVisitor<Unit>() {

    override fun visitFunctionExpression(ctx: PineScriptParser.FunctionExpressionContext?) {
        // TODO: for now we assume a function signature to not be nested
        // e.g. myObject.size()  is ok, but
        // myObject.innerObject.size() will fail
        //val path = ctx!!.Identifier()

//        val targetObject = if (path.size == 1) {
//            // function from owner
//            //val func = owner.getFunction(path[0].text)
//        } else {
//            // function from other object
//        }
    }
}