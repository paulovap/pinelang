package com.pinescript.core

import com.pinescript.core.PineValue.Companion.of
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.After
import org.junit.Before
import org.junit.Test

class TestValues {
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test fun testIntValue() {
        val data = 10
        val a = PineInt(data)
        assertEquals(data, a.getValue())
        assertEquals(data, a())
        assertEquals(PineInt(data), a)

        assertEquals(PineDouble(data.toDouble()), a.toDouble())

        assertEquals(a, a.toInt())
        // plus
        assertEquals(data + data, (a + a).getValue())
        // minus
        assertEquals(data - data, (a - a).getValue())
        // multi
        assertEquals(data * data, (a * a).getValue())
        // div
        assertEquals(data / data, (a / a).getValue())
        // remainder
        assertEquals(data % (data - 1), (a % (a + of(-1))).getValue())

        assertFailsWith(PineScriptException::class) { a + of("test") }
        assertFailsWith(PineScriptException::class) { a - of("test") }
        assertFailsWith(PineScriptException::class) { a * of("test") }
        assertFailsWith(PineScriptException::class) { a / of("test") }
        assertFailsWith(PineScriptException::class) { a % of("test") }
    }

    @Test fun testDoubleValue() {
        val data = 12.5
        val a = PineDouble(data)
        assertEquals(data, a.getValue())
        assertEquals(data, a())
        assertEquals(PineDouble(12.5), a)
        assertEquals(PineInt(12), a.toInt())
        assertEquals(a, a.toDouble())
        // plus
        assertEquals(data + data, (a + a).getValue())
        // minus
        assertEquals(data - data, (a - a).getValue())
        // multi
        assertEquals(data * data, (a * a).getValue())
        // div
        assertEquals(data / data, (a / a).getValue())
        // remainder
        assertEquals(data % (data - 1), (a % (a + of(-1))).getValue())

        assertFailsWith(PineScriptException::class) { a + of("test") }
        assertFailsWith(PineScriptException::class) { a - of("test") }
        assertFailsWith(PineScriptException::class) { a * of("test") }
        assertFailsWith(PineScriptException::class) { a / of("test") }
        assertFailsWith(PineScriptException::class) { a % of("test") }
    }

    @Test fun testNumberOperators() {
        val intVal = of(10)
        val doubleVal = of(20.0f)
        assertEquals(true, doubleVal.isNumber())
        assertEquals(false, doubleVal.isString())
        assertEquals(false, doubleVal.isFunction())
        assertEquals(false, doubleVal.isList())
        // plus
        assertEquals(30, (intVal + doubleVal).getValue())
        assertEquals(30.0, (doubleVal + intVal).getValue())
        // minus
        assertEquals(10.0, (doubleVal - intVal).getValue())
        // multi
        assertEquals(200.0, (doubleVal * intVal).getValue())
        // div
        assertEquals(2.0, (doubleVal / intVal).getValue())
        // remainder
        assertEquals(0.0, (doubleVal % intVal).getValue())
    }

    @Test fun testBooleanValue() {
        val trueValue = of(true)
        val falseValue = of(false)
        assertEquals(true, falseValue.isBool())
        assertEquals(false, falseValue.isNumber())
        assertEquals(true, trueValue.getValue())
        assertEquals(false, (!trueValue).getValue())
        assertEquals(PineType.BOOL, trueValue.getPineType())
        assert(trueValue != falseValue)

        assertEquals(of(true), trueValue)
        assertEquals(of(false), falseValue)

        // and
        assertEquals(false, trueValue.and(falseValue)())
        assertEquals(false, falseValue.and(trueValue)())
        assertEquals(false, falseValue.and(falseValue)())
        assertEquals(true, trueValue.and(trueValue)())
        // or
        assertEquals(true, trueValue.or(falseValue)())
        assertEquals(true, falseValue.or(trueValue)())
        assertEquals(false, falseValue.or(falseValue)())
        assertEquals(true, trueValue.or(trueValue)())
    }

    @Test fun testStringValue() {
        val data = "My String"
        val data2 = "Another String"
        val a = of(data)
        assertEquals(true, a.isString())
        assertEquals(false, a.isObject())
        assertEquals(data, a.getValue())
        assertEquals(data, a())
        assert(of(data2) != a)
    }

    @Test fun testInvocationValue() {
        val a = of(10)
        assertEquals(10, a())
        assertEquals(10, a(a))
        assertEquals(10, a(a, a))
        assertEquals(10, a(a, a, a))
        assertEquals(10, a(a, a, a, a))
    }
}
