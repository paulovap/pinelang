package com.pinescript.core

import com.pinescript.core.PineValue.Companion.of

enum class BinaryOp {
    PLUS, MINUS, MULTI, DIV, REMAINDER, AND, OR;

    fun isNumberOp() = this == PLUS || this == MINUS || this == MULTI || this == DIV || this == REMAINDER
    fun isBooleanOp() = this == AND || this == OR
}

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
        val BOOL = PineType("Bool", 1)
        val INT = PineType("Int", 2)
        val DOUBLE = PineType("Double", 3)
        val STRING = PineType("String", 4)
        val OBJECT = PineType("Object", 5)
        val LIST = PineType("List", 4)
        val FUNCTION = PineType("Function", 5)
        val LAMBDA = PineType("Lambda", 6)
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
        fun <T> of(value: T): PineValue<*> {
            return when (value) {
                is Int -> of(value)
                is Double -> of(value)
                is Float -> of(value)
                is Boolean -> of(value)
                is String -> of(value)
                else -> throw PineScriptException("Value $value not recognized")
            }
        }
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

data class PineBinaryExprValue<T>(
    val op: BinaryOp,
    val leftHandValue: PineValue<T>,
    val rightHandValue: PineValue<*>
) : ExprValue<T>({
    if (op.isNumberOp()) {
        val left = leftHandValue as PineNumber<T>
        when (op) {
            BinaryOp.PLUS -> (left + rightHandValue).getValue()
            BinaryOp.MINUS -> (left - rightHandValue).getValue()
            BinaryOp.MULTI -> (left * rightHandValue).getValue()
            BinaryOp.DIV -> (left / rightHandValue).getValue()
            BinaryOp.REMAINDER -> (left % rightHandValue).getValue()
            else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
        }
    } else {
        val left = leftHandValue as PineBoolean
        when (op) {
            BinaryOp.AND -> (left.and(rightHandValue) as PineValue<T>).getValue()
            BinaryOp.OR -> (left.or(rightHandValue) as PineValue<T>).getValue()
            else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
        }
    }
})

open class ExprValue<T>(val lambda: () -> T) : PineValue<T>() {

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