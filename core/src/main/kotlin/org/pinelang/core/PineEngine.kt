/*
BSD License

Copyright (c) $today.year, Paulo Pinheiro
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
package org.pinelang.core

import org.pinelang.ast.fbs.BinaryExpr
import org.pinelang.ast.fbs.CallableExpr
import org.pinelang.ast.fbs.Expr
import org.pinelang.ast.fbs.ExprValue
import org.pinelang.ast.fbs.ObjectDefinition
import org.pinelang.ast.fbs.PrimitiveExpr
import org.pinelang.ast.fbs.PrimitiveType
import org.pinelang.ast.fbs.Program
import org.pinelang.ast.fbs.PropDefinition
import org.pinelang.ast.fbs.PropRefExpr
import org.pinelang.ast.fbs.SignalExpr
import org.pinelang.core.PineExpr.Companion.of
import org.pinelang.core.PineType.Companion.BOOL
import org.pinelang.core.PineType.Companion.DOUBLE
import org.pinelang.core.PineType.Companion.INT
import org.pinelang.core.PineType.Companion.STRING
import org.pinelang.util.IndexedMap

typealias Allocator = (Int) -> PineObject

data class MetaProp(val name: String, val type: PineType)

class PineMetaObject(
    val scriptName: String,
    val docString: String = "",
    val allocator: Allocator
) {
    val allNames: Array<String>
    val props: Array<MetaProp>
    private val propIndexEnd: Int
    private val signalIndexEnd: Int
    private val callableIndexEnd: Int

    init {
        val pineObj = allocator(PineObject.INVALID_ID)
        propIndexEnd = pineObj.props.size - 1
        signalIndexEnd = propIndexEnd + pineObj.signals.size
        callableIndexEnd = signalIndexEnd + pineObj.callables.size
        props = pineObj.props.map {
            MetaProp(
                it.name,
                it.expr.pineType
            )
        }.toTypedArray()
        allNames = Array(callableIndexEnd + 1) {
            when {
                it <= propIndexEnd -> pineObj.props[it].getScriptName()
                it <= signalIndexEnd -> pineObj.signals[it - propIndexEnd - 1].getScriptName()
                else -> pineObj.callables[it - signalIndexEnd - 1].getScriptName()
            }
        }
    }

    fun propNames(): List<String> = allNames.slice(0..propIndexEnd)
    fun signalNames(): List<String> = allNames.slice((propIndexEnd + 1)..signalIndexEnd)
    fun callableNames(): List<String> = allNames.slice((signalIndexEnd + 1)..callableIndexEnd)

    fun indexOfProp(name: String): Int? = findRelative(0, propIndexEnd, name)

    fun indexOfSignal(name: String): Int? = findRelative(propIndexEnd + 1, signalIndexEnd, name)

    fun indexOfCallable(name: String): Int? =
        findRelative(signalIndexEnd + 1, callableIndexEnd, name)

    fun indexOfAny(name: String): Int? = findRelative(0, callableIndexEnd, name)

    private fun findRelative(start: Int, end: Int, name: String): Int? {
        for (i in start..end) {
            if (allNames[i] == name)
                return i - start
        }
        return null
    }
}

@ExperimentalUnsignedTypes
class PineEngine private constructor(
    val types: IndexedMap<PineMetaObject>,
    val dpCalculator: (Int) -> Int
) {

    private val rootContext: PineContext =
        PineContext()

    fun load(script: String, debugSymbol: Boolean = false): PineObject {
        return eval(
            PineCompiler(types).compile(script, debugSymbol))
    }

    fun compile(script: String, keepDebugSymbols: Boolean = false): Program {
        return PineCompiler(types)
            .compile(script, keepDebugSymbols)
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
        val prop = obj.props[propDef.id.toInt()]

        // ExprValue.PropRefExpr -> evalPropertyReferenceExp(expr.expValue(PropRefExpr())!! as PropRefExpr).value
        val exprValue = propDef.value!!
        val value: PineExpr<Any?> = if (exprValue.expValueType == ExprValue.PropRefExpr) {
            val otherProp =
                evalPropertyReferenceExp(exprValue.expValue(PropRefExpr())!! as PropRefExpr)
            val pineExpr = PineExpr(
                    pineType = otherProp.expr.pineType,
                    calculation = {
                otherProp.expr()
            })
            otherProp.connect { pineExpr.dirty = true }
            pineExpr
        } else {
            evalExpr(obj, exprValue)
        }

        prop.expr = value
    }

    @Suppress("CAST_NEVER_SUCCEEDS", "IMPLICIT_CAST_TO_ANY")
    private fun evalPrimitiveExpr(primitiveExpr: PrimitiveExpr): PineExpr<Any?> {
        return when (PineType.fromUByte(primitiveExpr.type)) {
            INT -> of(primitiveExpr.value.toInt())
            BOOL -> of(primitiveExpr.value.toInt() > 0)
            DOUBLE -> of(primitiveExpr.value)
            STRING -> of(primitiveExpr.stringValue!!)
            else -> throw PineScriptException(
                "Unable to eval primitive expr ${PrimitiveType.name(
                    primitiveExpr.type.toInt()
                )}"
            )
        } as PineExpr<Any?>
    }

    private fun evalExpr(owner: PineObject, expr: Expr): PineExpr<Any?> {

        return when (expr.expValueType) {
            ExprValue.PrimitiveExpr ->
                evalPrimitiveExpr(expr.expValue(PrimitiveExpr()) as PrimitiveExpr)
            ExprValue.CallableExpr ->
                evalCallableExpression(expr.expValue(CallableExpr()) as CallableExpr)
            ExprValue.BinaryExpr -> evalBinaryExpr(
                owner,
                expr.expValue(BinaryExpr()) as BinaryExpr
            )
            ExprValue.PropRefExpr ->
                evalPropertyReferenceExp(expr.expValue(PropRefExpr())!! as PropRefExpr).expr
            else -> throw PineScriptException(
                "Unable to evaluate expression of type ${ExprValue.name(
                    expr.expValueType.toInt()
                )}"
            )
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun evalBinaryExpr(owner: PineObject, binaryExpr: BinaryExpr): PineExpr<Any?> {

        val left = evalExpr(owner, binaryExpr.left!!)
        val right = evalExpr(owner, binaryExpr.right!!)
        return when {
            left.isDouble() or right.isDouble() ->
                BinaryNumberExpr<Double>(owner, "anon", binaryExpr.op, left, right)
            left.isInt() -> BinaryNumberExpr<Int>(owner, "anon", binaryExpr.op, left, right)
            left.isBool() ->
                BinaryLogicalExp(
                        owner,
                        "anon",
                        binaryExpr.op,
                        left as PineExpr<Boolean>,
                        right as PineExpr<Boolean>)
            else -> throw BinaryOpTypeMismatchPineScriptException(
                    binaryExpr.op,
                    left.pineType,
                    right.pineType)
        } as PineExpr<Any?>
    }

    private fun evalPropertyReferenceExp(propRefExpr: PropRefExpr): PineProp<*> {
        val otherObj = rootContext[propRefExpr.objId]!!
        return otherObj.props[propRefExpr.propId.toInt()]
    }

    private fun <T : PineObject> evalSignal(obj: T, sigExpr: SignalExpr) {
        val signal = obj.signals[sigExpr.id.toInt()]
        signal.connect { evalCallableExpression(sigExpr.expr!!)() }
    }

    @Suppress("CAST_NEVER_SUCCEEDS")
    private fun evalCallableExpression(expr: CallableExpr): PineExpr<Any?> {
        val otherObj = rootContext.refs[expr.objId]!!
        return otherObj.callables[expr.callIdx.toInt()] as PineExpr<Any?>
    }

    class Builder {
        private val types =
            IndexedMap<PineMetaObject>()
        private var dpCalc: (Int) -> Int = { it }

        init {
            // @TODO We need to allocate an registered object at least once, so we
            // can populate the PineMetaObject at runtime. This can be really error-prone
            // and allocates unnecessary. One option is to code generate, but for now we keep it
            // in runtime.
            // types["var"] = PineObject.getMeta()
            // registerPineType(PineItem.meta)
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
