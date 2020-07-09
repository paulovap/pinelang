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

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.pinelang.core.PineValue.Companion.of

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
