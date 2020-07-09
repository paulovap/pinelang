package org.pinelang.core

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.Test
import org.pinelang.ast.fbs.BinaryOp.Companion.AND
import org.pinelang.ast.fbs.BinaryOp.Companion.DIV
import org.pinelang.ast.fbs.BinaryOp.Companion.MINUS
import org.pinelang.ast.fbs.BinaryOp.Companion.MULTI
import org.pinelang.ast.fbs.BinaryOp.Companion.OR
import org.pinelang.ast.fbs.BinaryOp.Companion.PLUS
import org.pinelang.ast.fbs.BinaryOp.Companion.REMAINDER
import org.pinelang.core.PineType.Companion.FUNCTION
import org.pinelang.core.PineValue.Companion.of

class TestExpressions {

    class Item : PineObject(-1) {
        companion object {
            val meta = PineMetaObject("Item") { Item() }
        }

        override fun getMeta(): PineMetaObject = meta
    }

    @Test
    fun testBinaryMathExpressions() {

        val root = Item()
        val v10 = of(10)
        val v25 = of(25)

        assertEquals(35, BinaryExprValue(
            root,
            "anon",
            PLUS,
            v10,
            v25
        )())
        assertEquals(-15, BinaryExprValue(
            root,
            "anon",
            MINUS,
            v10,
            v25
        )())
        assertEquals(250, BinaryExprValue(
            root,
            "anon",
            MULTI,
            v10,
            v25
        )())
        assertEquals(2, BinaryExprValue(
            root,
            "anon",
            DIV,
            v25,
            v10
        )())
        assertEquals(5, BinaryExprValue(
            root,
            "anon",
            REMAINDER,
            v25,
            v10
        )())

        val exp =
            BinaryExprValue(root, "anon", AND, of(true), v10)
        assertEquals(FUNCTION, exp.getPineType())
        assertFailsWith(PineScriptException::class) { exp() }
    }

    @Test
    fun testBinaryBooleanExpressions() {
        val root = Item()
        val vTrue = of(true)
        val vFalse = of(false)

        assertEquals(true, BinaryExprValue(
            root,
            "anon",
            AND,
            vTrue,
            vTrue
        )())
        assertEquals(true, BinaryExprValue(
            root,
            "anon",
            OR,
            vTrue,
            vFalse
        )())
        assertFailsWith(PineScriptException::class) {
            BinaryExprValue(
                root,
                "anon",
                PLUS,
                of(10),
                vFalse
            )()
        }
    }
}
