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
package com.pinescript.core

import com.pinescript.ast.fbs.*
import com.pinescript.core.PineType.Companion.BOOL
import com.pinescript.core.PineType.Companion.DOUBLE
import com.pinescript.core.PineType.Companion.INT
import com.pinescript.core.PineType.Companion.STRING
import com.pinescript.core.PineValue.Companion.of
import com.pinescript.util.IndexedMap

typealias Allocator = (Int) -> PineObject


class PineMetaObject(val scriptName: String, val allocator: Allocator) {

    val propIndexes: Map<String, Int>
    val signalIndexes: Map<String, Int>
    val callableIndexes: Map<String, Int>

    init {
        val pineObj = allocator(-1)
        this.propIndexes = pineObj.props.index
        this.signalIndexes = pineObj.signals.index
        this.callableIndexes = pineObj.callables.index
    }
}

@ExperimentalUnsignedTypes
class PineEngine private constructor(
    val types: IndexedMap<PineMetaObject>,
    val dpCalculator: (Int) -> Int) {

    private val rootContext: PineContext = PineContext()
    val compiler: PineCompiler = PineCompiler(types)

    fun load(script: String, debugSymbol: Boolean = false): PineObject {
        return eval(compiler.compile(script, debugSymbol))
    }

    fun compile(script: String, keepDebugSymbols: Boolean = false): Program {
        return compiler.compile(script, keepDebugSymbols)
    }

    fun eval(program: Program): PineObject {
        rootContext.clear()
        val rootExpr = program.root!!
        return evalObject(rootExpr)
    }

    private fun evalObject(objExpr: ObjectDefinition): PineObject {
        val obj = types[objExpr.type]!!.allocator(objExpr.id)

        rootContext.registerObject(objExpr.id, obj)

        val childExpr = ObjectDefinition()
        for (i in 0 until objExpr.childrenLength) {
            obj.children.add(evalObject(objExpr.children(childExpr, i)!!))
        }

        val propExpr = PropDefinition()
        for (i in 0 until objExpr.propsLength) {
            evalProp(obj, objExpr.props(propExpr, i)!!)
        }

        val sigExpr = SignalExpr()
        for (i in 0 until objExpr.signalsLength) {
            objExpr.signals(sigExpr, i)
            evalSignal(obj, sigExpr)
        }

        obj.emitMount()
        return obj
    }

    private fun evalProp(obj: PineObject, propDef: PropDefinition) {
        val prop = obj.props[propDef.id.toInt()]!!

        //ExprValue.PropRefExpr -> evalPropertyReferenceExp(expr.expValue(PropRefExpr())!! as PropRefExpr).value
        val exprValue = propDef.value!!
        val value = if (exprValue.expValueType == ExprValue.PropRefExpr) {
            val otherProp = evalPropertyReferenceExp(exprValue.expValue(PropRefExpr())!! as PropRefExpr)
            otherProp.connect { prop.setPineValue(otherProp.value) }
            otherProp.value
        } else {
            evalExpr(exprValue)
        }

        prop.setPineValue(value)
    }

    private fun evalPrimitiveExpr(primitiveExpr: PrimitiveExpr): PineValue<*> {
        return when(PineType.fromUByte(primitiveExpr.type)) {
                INT -> of(primitiveExpr.value.toInt())
                BOOL -> of(primitiveExpr.value.toInt() > 0)
                DOUBLE -> of(primitiveExpr.value)
                STRING -> of(primitiveExpr.stringValue!!)
                else -> throw PineScriptException("Unable to eval primitive expr $primitiveExpr")
        }
    }

    private fun evalExpr(expr: Expr): PineValue<*> {

        return when (expr.expValueType) {
            ExprValue.PrimitiveExpr -> evalPrimitiveExpr(expr.expValue(PrimitiveExpr()) as PrimitiveExpr)
            ExprValue.CallableExpr -> evalCallableExpression(expr.expValue(CallableExpr()) as CallableExpr)
            ExprValue.BinaryExpr -> evalBinaryExpr(expr.expValue(BinaryExpr())!! as BinaryExpr)
            ExprValue.PropRefExpr -> evalPropertyReferenceExp(expr.expValue(PropRefExpr())!! as PropRefExpr).value
            else -> throw PineScriptException("Unable to evaluate expression of type ${ExprValue.name(expr.expValueType.toInt())}")
        }
    }
    private fun evalBinaryExpr(binaryExpr: BinaryExpr): BinaryExprValue<*> {
        return BinaryExprValue(binaryExpr.op, evalExpr(binaryExpr.left!!), evalExpr(binaryExpr.right!!))
    }

    private fun evalPropertyReferenceExp(propRefExpr: PropRefExpr): PineProp<*> {
        val otherObj = rootContext[propRefExpr.objId]!!
        return otherObj.props[propRefExpr.propId.toInt()]!!
    }

    private fun <T: PineObject> evalSignal(obj: T, sigExpr: SignalExpr) {
        val signal = obj.signals[sigExpr.id.toInt()]!!
        signal.connect { evalCallableExpression(sigExpr.expr!!)() }
    }

    private fun evalCallableExpression(expr: CallableExpr): PineValue<*> {
        val otherObj = rootContext.refs[expr.objId]!!
        return otherObj.callables[expr.callIdx.toInt()]!!
    }

    class Builder {
        private val types = IndexedMap<PineMetaObject>()
        private var dpCalc: (Int) -> Int = { it }
        init {
            // @TODO: For conversion reasons, ints always have to be Longs in QML.
            // The reason for this is Number.parse() returns Long for integers
            // Don't know best approach yet
            types["var"] = PineObject.meta
            types["Object"] = PineObject.meta
        }

        fun registerPineType(meta: PineMetaObject): Builder {
            types[meta.scriptName] = meta
            return this
        }

        fun pixelDensityCalculator(lambda: (Int) -> Int) {
            this.dpCalc = lambda
        }

        fun build(): PineEngine {
            return PineEngine(types, dpCalc)
        }
    }

}
