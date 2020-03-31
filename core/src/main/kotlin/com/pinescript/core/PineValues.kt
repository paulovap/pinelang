package com.pinescript.core

import com.pinescript.ast.fbs.BinaryOp
import com.pinescript.ast.fbs.BinaryOp.Companion.AND
import com.pinescript.ast.fbs.BinaryOp.Companion.DIV
import com.pinescript.ast.fbs.BinaryOp.Companion.MINUS
import com.pinescript.ast.fbs.BinaryOp.Companion.MULTI
import com.pinescript.ast.fbs.BinaryOp.Companion.OR
import com.pinescript.ast.fbs.BinaryOp.Companion.PLUS
import com.pinescript.ast.fbs.BinaryOp.Companion.REMAINDER
import com.pinescript.core.PineValue.Companion.of

interface PineNumber<T> {
    operator fun plus(other: PineValue<*>): PineValue<T>
    operator fun minus(other: PineValue<*>): PineValue<T>
    operator fun times(other: PineValue<*>): PineValue<T>
    operator fun div(other: PineValue<*>): PineValue<T>
    operator fun rem(other: PineValue<*>): PineValue<T>

    fun toDouble(): PineValue<Double>
    fun toInt(): PineValue<Int>
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
            return when(type.toInt()) {
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

abstract class PineValue<T> {

    abstract fun getPineType(): PineType

    abstract fun getValue(): T

    fun isBool() = getPineType() == PineType.BOOL
    fun isDouble() = getPineType() == PineType.DOUBLE
    fun isInt() = getPineType() == PineType.INT
    fun isNumber() = isInt() || isDouble()
    fun isString() = getPineType() == PineType.STRING
    fun isObject() = getPineType() == PineType.OBJECT
    fun isFunction() = getPineType() == PineType.FUNCTION
    fun isList() = getPineType() == PineType.LIST

    open operator fun invoke(): T = throw PineScriptException("Value of type ${getPineType()} is not invokable")
    open operator fun invoke(arg: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>, arg2: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>, arg2: PineValue<*>, arg3: PineValue<*>): T = this()

    companion object {
        fun of(value: Int) = PineInt(value)
        fun of(value: Double) = PineDouble(value)
        fun of(value: Float) = PineDouble(value.toDouble())
        fun of(value: Boolean) = PineBoolean(value)
        fun of(value: String) = PineString(value)
        fun of(value: List<*>) = PineList(value)
        fun <T> of(value: T): PineValue<*> {
            return when (value) {
                is Int -> of(value)
                is Double -> of(value)
                is Float -> of(value)
                is Boolean -> of(value)
                is String -> of(value)
                is List<*> -> of(value)
                is MutableList<*> -> of(value)
                else -> throw PineScriptException("Value $value not recognized")
            }
        }
    }

    fun toPineDouble(): PineDouble {
        return if (isNumber()){
            if (isInt()) {
                of((this as PineInt).getValue().toDouble())
            } else {
                this as PineDouble
            }
        } else throw PineScriptException("$this cannot be cast to PineDouble")
    }
    fun toPineInt(): PineInt {
        return if (isNumber()){
            if (isDouble()) {
                of((this as PineDouble).getValue().toInt())
            } else {
                this as PineInt
            }
        } else throw PineScriptException("$this cannot be cast to PineDouble")
    }
}

data class PineInt(private val value: Int) : PineNumber<Int>, PineValue<Int>() {

    override fun getPineType(): PineType = PineType.INT
    override fun getValue(): Int = value
    override operator fun invoke(): Int = value


    override fun plus(other: PineValue<*>): PineValue<Int> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineInt(value + (other as PineDouble).getValue().toInt())
            PineType.INT -> PineInt(value + (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun minus(other: PineValue<*>): PineValue<Int> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineInt(value - (other as PineDouble).getValue().toInt())
            PineType.INT -> PineInt(value - (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun times(other: PineValue<*>): PineValue<Int> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineInt(value * (other as PineDouble).getValue().toInt())
            PineType.INT -> PineInt(value * (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun div(other: PineValue<*>): PineValue<Int> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineInt(value / (other as PineDouble).getValue().toInt())
            PineType.INT -> PineInt(value / (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun rem(other: PineValue<*>): PineValue<Int> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineInt(value % (other as PineDouble).getValue().toInt())
            PineType.INT -> PineInt(value % (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun toDouble(): PineValue<Double> = of(value.toDouble())
    override fun toInt(): PineValue<Int> = of(value)

}

data class PineDouble(private val value: Double) : PineNumber<Double>, PineValue<Double>() {

    override fun getPineType(): PineType = PineType.DOUBLE

    override fun getValue(): Double = value
    override operator fun invoke(): Double = value

    override fun plus(other: PineValue<*>): PineValue<Double> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineDouble(value + (other as PineDouble).value)
            PineType.INT -> PineDouble(value + (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun minus(other: PineValue<*>): PineValue<Double> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineDouble(value - (other as PineDouble).value)
            PineType.INT -> PineDouble(value - (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun times(other: PineValue<*>): PineValue<Double> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineDouble(value * (other as PineDouble).value)
            PineType.INT -> PineDouble(value * (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun div(other: PineValue<*>): PineValue<Double> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineDouble(value / (other as PineDouble).value)
            PineType.INT -> PineDouble(value / (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun rem(other: PineValue<*>): PineValue<Double> {
        return when (other.getPineType()) {
            PineType.DOUBLE -> PineDouble(value % (other as PineDouble).value)
            PineType.INT -> PineDouble(value % (other as PineInt).getValue())
            else -> throw PineScriptException("unable to apply operator plus with types ${getPineType()} and ${other.getPineType()}")
        }
    }

    override fun toDouble(): PineValue<Double> = of(value)
    override fun toInt(): PineValue<Int> = of(value.toInt())
}

data class PineBoolean(val value: Boolean) : PineValue<Boolean>() {
    override fun getPineType(): PineType = PineType.BOOL
    override fun getValue(): Boolean = value

    fun and(other: PineValue<*>) = when (other.getPineType()) {
        PineType.BOOL -> of(value && (other as PineValue<Boolean>).getValue())
        else -> throw PineScriptException("unable to apply operator 'and' with types ${getPineType()} and ${other.getPineType()}")
    }

    fun or(other: PineValue<*>) = when (other.getPineType()) {
        PineType.BOOL -> of(value || (other as PineValue<Boolean>).getValue())
        else -> throw PineScriptException("unable to apply operator 'or' with types ${getPineType()} and ${other.getPineType()}")
    }

    operator fun not(): PineBoolean = of(!value)
    override operator fun invoke(): Boolean = value
}

data class PineString(private val value: String) : PineValue<String>() {
    override fun getPineType(): PineType = PineType.STRING
    override fun getValue() = value
    override operator fun invoke(): String = value
}

data class PineList(private val value: List<*>) : PineValue<List<*>>() {
    override fun getPineType(): PineType = PineType.LIST
    override fun getValue() = value
    override operator fun invoke(): List<*> = value
}

data class BinaryExprValue<T>(
    val op: UByte,
    val leftHandValue: PineValue<T>,
    val rightHandValue: PineValue<*>
) : PineExprValue<T>({
    val pineValue = if (op.isNumberOp()) {
        if (leftHandValue.isDouble() || rightHandValue.isDouble()) {
            val left = leftHandValue.toPineDouble()
            when (op) {
                PLUS -> (left + rightHandValue)
                MINUS -> (left - rightHandValue)
                MULTI -> (left * rightHandValue)
                DIV -> (left / rightHandValue)
                REMAINDER -> (left % rightHandValue)
                else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
            }
        } else {
            val left = leftHandValue.toPineInt()
            when (op) {
                PLUS -> (left + rightHandValue)
                MINUS -> (left - rightHandValue)
                MULTI -> (left * rightHandValue)
                DIV -> (left / rightHandValue)
                REMAINDER -> (left % rightHandValue)
                else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
            }
        }
    } else {
        val left = leftHandValue as PineBoolean
        when (op) {
            AND -> left.and(rightHandValue)
            OR -> left.or(rightHandValue)
            else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
        }
    } as PineValue<T>
    pineValue.getValue()
})

open class PineExprValue<T>(val lambda: () -> T) : PineValue<T>() {

    override fun getPineType(): PineType = PineType.FUNCTION
    override operator fun invoke(): T = getValue()
    override fun getValue(): T = lambda()
}

fun String.toPineValue() = of(this)
fun Int.toPineValue() = of(this)
fun Double.toPineValue() = of(this)
fun Float.toPineValue() = of(this)
fun Long.toPineValue() = of(this)
fun Boolean.toPineValue() = of(this)

private fun UByte.isNumberOp() = this == PLUS || this == MINUS || this == MULTI || this == DIV || this == REMAINDER
private fun UByte.isBooleanOp() = this == AND || this == OR