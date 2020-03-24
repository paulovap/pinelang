package com.flex.core

import com.flex.core.PineValue.Companion.of
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestValue {
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test fun testIntValue(){
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
        assertEquals(data % (data -1), (a % (a + of(-1))).getValue())

        assertFailsWith(PineScriptException::class) {a + of("test")}
        assertFailsWith(PineScriptException::class) {a - of("test")}
        assertFailsWith(PineScriptException::class) {a * of("test")}
        assertFailsWith(PineScriptException::class) {a / of("test")}
        assertFailsWith(PineScriptException::class) {a % of("test")}
    }

    @Test fun testDoubleValue(){
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
        assertEquals(data % (data -1), (a % (a + of(-1))).getValue())

        assertFailsWith(PineScriptException::class) {a + of("test")}
        assertFailsWith(PineScriptException::class) {a - of("test")}
        assertFailsWith(PineScriptException::class) {a * of("test")}
        assertFailsWith(PineScriptException::class) {a / of("test")}
        assertFailsWith(PineScriptException::class) {a % of("test")}
    }

    @Test fun testNumberOperators() {
        val intVal = of(10)
        val doubleVal = of(20.0f)

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
}