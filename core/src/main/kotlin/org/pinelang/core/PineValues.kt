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

import org.pinelang.ast.fbs.BinaryOp.Companion.AND
import org.pinelang.ast.fbs.BinaryOp.Companion.DIV
import org.pinelang.ast.fbs.BinaryOp.Companion.MINUS
import org.pinelang.ast.fbs.BinaryOp.Companion.MULTI
import org.pinelang.ast.fbs.BinaryOp.Companion.OR
import org.pinelang.ast.fbs.BinaryOp.Companion.PLUS
import org.pinelang.ast.fbs.BinaryOp.Companion.REMAINDER

interface PineNumber<T> {
    operator fun plus(other: PineExpr<*>): PineExpr<T>
    operator fun minus(other: PineExpr<*>): PineExpr<T>
    operator fun times(other: PineExpr<*>): PineExpr<T>
    operator fun div(other: PineExpr<*>): PineExpr<T>
    operator fun rem(other: PineExpr<*>): PineExpr<T>

    fun toDouble(): PineExpr<Double>
    fun toInt(): PineExpr<Int>
}

data class PineType(val typeName: String, val type: Int) {
    companion object {
        val VOID = PineType("Void", 0)
        val INT = PineType("Int", 1)
        val BOOL = PineType("Bool", 2)
        val DOUBLE = PineType("Double", 3)
        val STRING = PineType("String", 4)
        val OBJECT = PineType("Object", 5)
        val LIST = PineType("List", 4)
        val FUNCTION = PineType("Function", 5)
        val LAMBDA = PineType("Lambda", 6)

        fun fromUByte(type: UByte): PineType {
            return when (type.toInt()) {
                VOID.type -> VOID
                INT.type -> INT
                BOOL.type -> BOOL
                DOUBLE.type -> DOUBLE
                STRING.type -> STRING
                OBJECT.type -> OBJECT
                LIST.type -> LIST
                FUNCTION.type -> FUNCTION
                LAMBDA.type -> LAMBDA
                else -> throw PineScriptException("invalid PineType $type")
            }
        }
    }
}

data class PineInt(private val value: Int) : PineNumber<Int>, PineExpr<Int>(
        pineType = PineType.INT,
        cached = value,
        calculation = { value }) {

    override fun plus(other: PineExpr<*>): PineInt {
        return when (other.pineType) {
            PineType.DOUBLE -> PineInt(this() + (other() as Double).toInt())
            PineType.INT -> PineInt(this() + other() as Int)
            else -> throw BinaryOpTypeMismatchPineScriptException(
                PLUS,
                pineType,
                other.pineType
            )
        }
    }

    override fun minus(other: PineExpr<*>): PineInt {
        return when (other.pineType) {
            PineType.DOUBLE -> PineInt(this() - (other() as Double).toInt())
            PineType.INT -> PineInt(this() - other() as Int)
            else -> throw BinaryOpTypeMismatchPineScriptException(
                MINUS,
                pineType,
                other.pineType
            )
        }
    }

    override fun times(other: PineExpr<*>): PineInt {
        return when (other.pineType) {
            PineType.DOUBLE -> PineInt(this() * (other() as Double).toInt())
            PineType.INT -> PineInt(this() * other() as Int)
            else -> throw BinaryOpTypeMismatchPineScriptException(
                MULTI,
                pineType,
                other.pineType
            )
        }
    }

    override fun div(other: PineExpr<*>): PineInt {
        return when (other.pineType) {
            PineType.DOUBLE -> PineInt(this() / (other() as Double).toInt())
            PineType.INT -> PineInt(this() / other() as Int)
            else -> throw BinaryOpTypeMismatchPineScriptException(
                DIV,
                pineType,
                other.pineType
            )
        }
    }

    override fun rem(other: PineExpr<*>): PineInt {
        return when (other.pineType) {
            PineType.DOUBLE -> PineInt(this() % (other() as Double).toInt())
            PineType.INT -> PineInt(this() % (other() as Int))
            else -> throw BinaryOpTypeMismatchPineScriptException(
                REMAINDER,
            pineType,
            other.pineType
            )
        }
    }

    override fun toDouble(): PineDouble = PineDouble(this().toDouble())
    override fun toInt(): PineInt = PineInt(this())
}

data class PineDouble(private val value: Double) : PineNumber<Double>, PineExpr<Double>(
        pineType = PineType.DOUBLE,
        cached = value,
        calculation = { value }) {

    override fun plus(other: PineExpr<*>): PineDouble {
        return when (other.pineType) {
            PineType.DOUBLE -> PineDouble(this() + (other as PineDouble)())
            PineType.INT -> PineDouble(this() + (other() as Int).toDouble())
            else -> throw BinaryOpTypeMismatchPineScriptException(
                PLUS,
                pineType,
                other.pineType
            )
        }
    }

    override fun minus(other: PineExpr<*>): PineDouble {
        return when (other.pineType) {
            PineType.DOUBLE -> PineDouble(this() - other() as Double)
            PineType.INT -> PineDouble(this() - (other() as Int).toDouble())
            else -> throw BinaryOpTypeMismatchPineScriptException(
                MINUS,
                pineType,
                other.pineType
            )
        }
    }

    override fun times(other: PineExpr<*>): PineDouble {
        return when (other.pineType) {
            PineType.DOUBLE -> PineDouble(this() * other() as Double)
            PineType.INT -> PineDouble(this() * (other() as Int))
            else -> throw BinaryOpTypeMismatchPineScriptException(
                MULTI,
                pineType,
                other.pineType
            )
        }
    }

    override fun div(other: PineExpr<*>): PineDouble {
        return when (other.pineType) {
            PineType.DOUBLE -> PineDouble(this() / (other() as Double))
            PineType.INT -> PineDouble(this() / (other() as Int))
            else -> throw BinaryOpTypeMismatchPineScriptException(
                DIV,
                pineType,
                other.pineType
            )
        }
    }

    override fun rem(other: PineExpr<*>): PineDouble {
        return when (other.pineType) {
            PineType.DOUBLE -> PineDouble(this() % (other() as Double))
            PineType.INT -> PineDouble(this() % (other() as Int))
            else -> throw BinaryOpTypeMismatchPineScriptException(
                REMAINDER,
                pineType,
                other.pineType
            )
        }
    }

    override fun toDouble(): PineDouble = PineDouble(this())
    override fun toInt(): PineExpr<Int> = PineInt(this().toInt())
}

data class PineBoolean(private val value: Boolean) : PineExpr<Boolean>(
        pineType = PineType.BOOL,
        cached = value,
        calculation = { value }
) {

    fun and(other: PineExpr<*>) = when (other.pineType) {
        PineType.BOOL -> of(this() && other() as Boolean)
        else -> throw BinaryOpTypeMismatchPineScriptException(
            AND,
            pineType,
            other.pineType
        )
    }

    fun or(other: PineExpr<*>) = when (other.pineType) {
        PineType.BOOL -> PineBoolean(this() || other() as Boolean)
        else -> throw BinaryOpTypeMismatchPineScriptException(
            OR,
            pineType,
            other.pineType
        )
    }

    operator fun not(): PineBoolean = PineBoolean(!this())
}

data class PineString(private val value: String) : PineExpr<String>(
        pineType = PineType.STRING,
        calculation = { value }
)

data class PineList(private val value: List<*>) : PineExpr<List<*>>(
        pineType = PineType.LIST,
        calculation = { value }
)

class BinaryLogicalExp(
    val owner: PineObject,
    val name: String,
    val op: UByte,
    val lhv: PineExpr<Boolean>,
    val rhv: PineExpr<Boolean>
) : PineExpr<Boolean>(
    pineType = PineType.BOOL,
    calculation = {
        when (op) {
            AND -> lhv().and(rhv())
            OR -> lhv().or(rhv())
            else -> throw BinaryOpNotSupportedPineScriptException(op, lhv.pineType)
            }
    })

@Suppress("UNCHECKED_CAST")
class BinaryNumberExpr<T>(
    val owner: PineObject,
    val name: String,
    val op: UByte,
    lhv: PineExpr<*>,
    rhv: PineExpr<*>
) : PineExpr<T>(
        pineType = resultType(op, lhv, rhv),
        calculation = {

        val left = if (lhv.isDouble() || rhv.isDouble()) {
                if (lhv.isInt()) {
                    PineDouble((lhv() as Int).toDouble()) as PineNumber<T>
                } else {
                    PineDouble(lhv() as Double) as PineNumber<T>
                }
            } else {
                PineInt(lhv() as Int) as PineNumber<T>
            }
        when (op) {
            PLUS -> (left + rhv)()
            MINUS -> (left - rhv)()
            MULTI -> (left * rhv)()
            DIV -> (left / rhv)()
            REMAINDER -> (left % rhv)()
            else -> throw BinaryOpNotSupportedPineScriptException(op, lhv.pineType)
        }
}) {
    companion object {
        fun resultType(op: UByte, lhv: PineExpr<*>, rhv: PineExpr<*>): PineType {
            if (!lhv.isNumber()) {
                throw BinaryOpNotSupportedPineScriptException(op, lhv.pineType)
            }
            if (!rhv.isNumber()) {
                throw BinaryOpNotSupportedPineScriptException(op, rhv.pineType)
            }
            if (lhv.isDouble() || rhv.isDouble())
                return PineType.DOUBLE
            return PineType.INT
        }
    }
}

@Suppress("UNCHECKED_CAST")
open class PineExpr<T>(
    var dirty: Boolean = true,
    val pineType: PineType,
    private var cached: Any = EMPTY,
    var calculation: () -> T
) {
    companion object {
        val EMPTY = object : Any() {
            override fun toString(): String {
                return "EMPTY"
            }
        }

        fun of(value: Int) = PineInt(value)
        fun of(value: Double) = PineDouble(value)
        fun of(value: Float) = PineDouble(value.toDouble())
        fun of(value: Boolean) = PineBoolean(value)
        fun of(value: String) = PineString(value)
        fun of(value: List<*>) = PineList(value)
        fun <T> of(value: T): PineExpr<*> {
            return when (value) {
                is Int -> of(value)
                is Double -> of(value)
                is Float -> of(value)
                is Boolean -> of(value)
                else -> throw PineScriptException("Value $value not recognized")
            }
        }
    }

    operator fun invoke(): T {
        if (dirty) {
            cached = calculation() as Any
            dirty = true
        }
        return cached as T
    }

    fun isBool() = pineType == PineType.BOOL
    fun isDouble() = pineType == PineType.DOUBLE
    fun isInt() = pineType == PineType.INT
    fun isNumber() = isInt() || isDouble()
    fun isString() = pineType == PineType.STRING
    fun isObject() = pineType == PineType.OBJECT
    fun isFunction() = pineType == PineType.FUNCTION
    fun isList() = pineType == PineType.LIST
}

class PineCallable<T>(val owner: PineObject, val name: String, val lambda: () -> T) :
    PineSignal, PineExpr<T>(pineType = PineType.FUNCTION, calculation = lambda) {
    override fun getPineObject(): PineObject = owner
    override fun getScriptName(): String = name
}

fun UByte.isNumberOp() =
    this == PLUS || this == MINUS || this == MULTI || this == DIV || this == REMAINDER

fun intExpr(calculation: () -> Int) =
        PineExpr(pineType = PineType.INT, calculation = calculation) as PineExpr<Any?>
fun boolExpr(calculation: () -> Boolean) =
        PineExpr(pineType = PineType.BOOL, calculation = calculation) as PineExpr<Any?>
fun stringExpr(calculation: () -> String) =
        PineExpr(pineType = PineType.STRING, calculation = calculation) as PineExpr<Any?>
fun doubleExpr(calculation: () -> Double) =
        PineExpr(pineType = PineType.DOUBLE, calculation = calculation) as PineExpr<Any?>
