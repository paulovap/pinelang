package com.flex.core

import com.flex.core.PineValue.Companion.of
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestExpressions {

    @Test
    fun testBinaryMathExpressions() {
        val v10 = of(10)
        val v25 = of(25)

        assertEquals(35, PineBinaryExprValue(BinaryOp.PLUS, v10, v25)())
        assertEquals(-15, PineBinaryExprValue(BinaryOp.MINUS, v10, v25)())
        assertEquals(250, PineBinaryExprValue(BinaryOp.MULTI, v10, v25)())
        assertEquals(2, PineBinaryExprValue(BinaryOp.DIV, v25, v10)())
        assertEquals(5, PineBinaryExprValue(BinaryOp.REMAINDER, v25, v10)())

        val exp = PineBinaryExprValue(BinaryOp.AND, of(true), v10)
        assertEquals(PineType.FUNCTION, exp.getPineType())
        assertFailsWith(PineScriptException::class) {exp()}
    }

    @Test
    fun testBinaryBooleanExpressions() {
        val vTrue = of(true)
        val vFalse = of(false)

        assertEquals(true, PineBinaryExprValue(BinaryOp.AND, vTrue, vTrue)())
        assertEquals(true, PineBinaryExprValue(BinaryOp.OR, vTrue, vFalse)())
        assertFailsWith(PineScriptException::class) {PineBinaryExprValue(BinaryOp.PLUS, of(10), vFalse)()}
    }
}