package com.flex.core

enum class BinaryOperations {
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