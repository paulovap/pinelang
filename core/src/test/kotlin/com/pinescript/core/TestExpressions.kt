package com.pinescript.core

import com.pinescript.ast.fbs.BinaryOp
import com.pinescript.ast.fbs.BinaryOp.Companion.AND
import com.pinescript.ast.fbs.BinaryOp.Companion.DIV
import com.pinescript.ast.fbs.BinaryOp.Companion.MINUS
import com.pinescript.ast.fbs.BinaryOp.Companion.MULTI
import com.pinescript.ast.fbs.BinaryOp.Companion.OR
import com.pinescript.ast.fbs.BinaryOp.Companion.PLUS
import com.pinescript.ast.fbs.BinaryOp.Companion.REMAINDER
import com.pinescript.core.PineType.Companion.FUNCTION
import com.pinescript.core.PineValue.Companion.of
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TestExpressions {

    @Test
    fun testBinaryMathExpressions() {
        val v10 = of(10)
        val v25 = of(25)

        assertEquals(35, BinaryExprValue(PLUS, v10, v25)())
        assertEquals(-15, BinaryExprValue(MINUS, v10, v25)())
        assertEquals(250, BinaryExprValue(MULTI, v10, v25)())
        assertEquals(2, BinaryExprValue(DIV, v25, v10)())
        assertEquals(5, BinaryExprValue(REMAINDER, v25, v10)())

        val exp = BinaryExprValue(AND, of(true), v10)
        assertEquals(FUNCTION, exp.getPineType())
        assertFailsWith(PineScriptException::class) {exp()}
    }

    @Test
    fun testBinaryBooleanExpressions() {
        val vTrue = of(true)
        val vFalse = of(false)

        assertEquals(true, BinaryExprValue(AND, vTrue, vTrue)())
        assertEquals(true, BinaryExprValue(OR, vTrue, vFalse)())
        assertFailsWith(PineScriptException::class) {BinaryExprValue(PLUS, of(10), vFalse)()}
    }
}