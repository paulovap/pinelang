/*
BSD License

Copyright (c) 2020, Paulo Pinheiro
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

class PineInt(vararg refs: PineExpr<*>, calculation: () -> Int) :
    PineNumber<Int>,
    PineExpr<Int>(pineType = PineType.INT, calculation = calculation, refs = *refs) {

  constructor(value: Int) : this(calculation = { value })

  override fun plus(other: PineExpr<*>): PineInt {
    return when (other.pineType) {
      PineType.DOUBLE -> PineInt(this, other) { this() + (other() as Double).toInt() }
      PineType.INT -> PineInt(this, other) { this() + other() as Int }
      else -> throw BinaryOpException(PLUS, pineType, other.pineType)
    }
  }

  override fun minus(other: PineExpr<*>): PineInt {
    return when (other.pineType) {
      PineType.DOUBLE -> PineInt(this, other) { this() - (other() as Double).toInt() }
      PineType.INT -> PineInt(this, other) { this() - other() as Int }
      else -> throw BinaryOpException(MINUS, pineType, other.pineType)
    }
  }

  override fun times(other: PineExpr<*>): PineInt {
    return when (other.pineType) {
      PineType.DOUBLE -> PineInt(this, other) { this() * (other() as Double).toInt() }
      PineType.INT -> PineInt(this, other) { this() * other() as Int }
      else -> throw BinaryOpException(MULTI, pineType, other.pineType)
    }
  }

  override fun div(other: PineExpr<*>): PineInt {
    return when (other.pineType) {
      PineType.DOUBLE -> PineInt(this, other) { this() / (other() as Double).toInt() }
      PineType.INT -> PineInt(this, other) { this() / other() as Int }
      else -> throw BinaryOpException(DIV, pineType, other.pineType)
    }
  }

  override fun rem(other: PineExpr<*>): PineInt {
    return when (other.pineType) {
      PineType.DOUBLE -> PineInt(this, other) { this() % (other() as Double).toInt() }
      PineType.INT -> PineInt(this, other) { this() % (other() as Int) }
      else -> throw BinaryOpException(REMAINDER, pineType, other.pineType)
    }
  }

  override fun equals(other: Any?): Boolean {
    if (other == null || other !is PineInt) return false
    return this() == other()
  }

  override fun toDouble(): PineDouble = PineDouble(this) { this().toDouble() }
  override fun toInt(): PineInt = PineInt(this) { this() }
  override fun hashCode(): Int {
    return javaClass.hashCode()
  }
}

class PineDouble(vararg refs: PineExpr<*>, calculation: () -> Double) :
    PineNumber<Double>,
    PineExpr<Double>(pineType = PineType.DOUBLE, refs = *refs, calculation = calculation) {

  constructor(value: Double) : this(calculation = { value })

  override fun plus(other: PineExpr<*>): PineDouble {
    return when (other.pineType) {
      PineType.DOUBLE -> PineDouble(this, other) { this() + (other as PineDouble)() }
      PineType.INT -> PineDouble(this, other) { this() + (other() as Int).toDouble() }
      else -> throw BinaryOpException(PLUS, pineType, other.pineType)
    }
  }

  override fun minus(other: PineExpr<*>): PineDouble {
    return when (other.pineType) {
      PineType.DOUBLE -> PineDouble(this, other) { this() - other() as Double }
      PineType.INT -> PineDouble(this, other) { this() - (other() as Int).toDouble() }
      else -> throw BinaryOpException(MINUS, pineType, other.pineType)
    }
  }

  override fun times(other: PineExpr<*>): PineDouble {
    return when (other.pineType) {
      PineType.DOUBLE -> PineDouble(this, other) { this() * other() as Double }
      PineType.INT -> PineDouble(this, other) { this() * (other() as Int) }
      else -> throw BinaryOpException(MULTI, pineType, other.pineType)
    }
  }

  override fun div(other: PineExpr<*>): PineDouble {
    return when (other.pineType) {
      PineType.DOUBLE -> PineDouble(this, other) { this() / (other() as Double) }
      PineType.INT -> PineDouble(this, other) { this() / (other() as Int) }
      else -> throw BinaryOpException(DIV, pineType, other.pineType)
    }
  }

  override fun rem(other: PineExpr<*>): PineDouble {
    return when (other.pineType) {
      PineType.DOUBLE -> PineDouble(this, other) { this() % (other() as Double) }
      PineType.INT -> PineDouble(this, other) { this() % (other() as Int) }
      else -> throw BinaryOpException(REMAINDER, pineType, other.pineType)
    }
  }

  override fun toDouble(): PineDouble = PineDouble(this) { this() }
  override fun toInt(): PineExpr<Int> = PineInt(calculation = { this().toInt() })

  override fun equals(other: Any?): Boolean {
    if (other == null || other !is PineDouble) return false
    return this() == other()
  }

  override fun hashCode(): Int {
    return 31 * this().hashCode()
  }
}

class PineBoolean(vararg refs: PineExpr<*>, calculation: () -> Boolean) :
    PineExpr<Boolean>(pineType = PineType.BOOL, refs = *refs, calculation = calculation) {

  constructor(value: Boolean) : this(calculation = { value })

  infix fun and(other: PineExpr<*>) =
      when (other.pineType) {
        PineType.BOOL -> PineBoolean(this) { this() && other() as Boolean }
        else -> throw BinaryOpException(AND, pineType, other.pineType)
      }

  infix fun or(other: PineExpr<*>) =
      when (other.pineType) {
        PineType.BOOL -> PineBoolean(this) { this() || other() as Boolean }
        else -> throw BinaryOpException(OR, pineType, other.pineType)
      }

  operator fun not(): PineBoolean = PineBoolean(this) { !this() }

  override fun hashCode(): Int {
    return if (this()) 1 else 0
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is PineExpr<*>) return false
    return this() == other()
  }
}

class PineString(vararg refs: PineExpr<*>, calculation: () -> String) :
    PineExpr<String>(pineType = PineType.STRING, refs = *refs, calculation = calculation) {
  constructor(value: String) : this(calculation = { value })

  operator fun plus(other: PineExpr<*>): PineString {
    return PineString(this, other) { this() + (other as PineString)() }
  }
}

class PineList(vararg refs: PineExpr<*>, calculation: () -> List<*>) :
    PineExpr<List<*>>(pineType = PineType.LIST, refs = *refs, calculation = calculation) {
  constructor(value: List<*>) : this(calculation = { value })
}

@Suppress("UNCHECKED_CAST")
open class PineExpr<T>(
    val pineType: PineType, protected vararg var refs: PineExpr<*>, private var calculation: () -> T
) {
  private var cached: T? = null
  protected var dirty = true
  private val emmiter: () -> Unit =
      {
        dirty = true
        emit()
      }

  init {
    refs.forEach { it.connect(emmiter) }
  }

  var listeners: MutableList<() -> Unit>? = null
  val listenerCount: Int
    get() = listeners?.size ?: 0

  fun connect(lambda: () -> Unit) {
    if (listeners == null) {
      listeners = mutableListOf()
    }
    listeners?.add(lambda)
  }
  fun disconnect(lambda: () -> Unit, all: Boolean = true) {
    if (all) listeners?.removeAll { it == lambda } else listeners?.remove(lambda)
  }

  fun emit() = listeners?.forEach { it() }

  fun move(other: PineExpr<T>) = update(refs = *other.refs, calculation = other.calculation)

  fun update(vararg refs: PineExpr<*>, calculation: () -> T) {
    this.refs.forEach { it.disconnect(emmiter) }
    refs.forEach { it.connect(emmiter) }
    this.refs = refs
    this.calculation = calculation
    this.dirty = true
    emit()
  }

  companion object {
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
    if (dirty || cached == null) {
      cached = calculation()
      dirty = false
    }
    return cached as T
  }

  fun isBoolean() = pineType == PineType.BOOL
  fun isDouble() = pineType == PineType.DOUBLE
  fun isInt() = pineType == PineType.INT
  fun isNumber() = isInt() || isDouble()
  fun isString() = pineType == PineType.STRING
  fun isObject() = pineType == PineType.OBJECT
  fun isFunction() = pineType == PineType.FUNCTION
  fun isList() = pineType == PineType.LIST

  fun toPineDouble(): PineDouble {
    if (isInt()) {
      return PineDouble(this) { (this() as Int).toDouble() }
    }
    if (!isDouble()) {
      throwInvalidCast(PineType.DOUBLE)
    }
    return this as PineDouble
  }

  fun toPineInt(): PineInt {
    if (isDouble()) {
      return PineInt(this) { (this() as Double).toInt() }
    }
    if (!isInt()) {
      throwInvalidCast(PineType.INT)
    }
    return this as PineInt
  }

  fun toPineString(): PineString {
    if (!isString()) {
      throwInvalidCast(PineType.STRING)
    }
    return this as PineString
  }

  fun toPineBoolean(): PineBoolean {
    if (!isBoolean()) {
      throwInvalidCast(PineType.BOOL)
    }
    return this as PineBoolean
  }

  open fun pineEquals(other: PineExpr<*>): PineBoolean {
    return PineBoolean(this, other) {
      this() == other()
    }
  }

  private fun throwInvalidCast(pineType: PineType) {
    throw PineScriptException("unable to cast ${this.pineType} to $pineType")
  }
}

class PineCallable<T>(val owner: PineObject, val name: String, val lambda: () -> T) :
    PineExpr<T>(pineType = PineType.FUNCTION, calculation = lambda) {}

fun UByte.isNumberOp() =
    this == PLUS || this == MINUS || this == MULTI || this == DIV || this == REMAINDER

fun intExpr(value: Int): PineInt = PineInt(calculation = { value })

fun boolExpr(calculation: () -> Boolean) = PineBoolean(calculation = calculation)

fun stringExpr(calculation: () -> String) = PineString(calculation = calculation)

fun doubleExpr(calculation: () -> Double) = PineDouble(calculation = calculation)
