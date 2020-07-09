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
import org.junit.Test
import org.pinelang.ast.fbs.BinaryOp.Companion.AND
import org.pinelang.ast.fbs.BinaryOp.Companion.DIV
import org.pinelang.ast.fbs.BinaryOp.Companion.MINUS
import org.pinelang.ast.fbs.BinaryOp.Companion.MULTI
import org.pinelang.ast.fbs.BinaryOp.Companion.OR
import org.pinelang.ast.fbs.BinaryOp.Companion.PLUS
import org.pinelang.ast.fbs.BinaryOp.Companion.REMAINDER
import org.pinelang.core.PineExpr.Companion.of

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

        assertEquals(35, BinaryNumberExpr<Int>(
            root,
            "anon",
            PLUS,
            v10,
            v25
        )())
        assertEquals(-15, BinaryNumberExpr<Int>(
            root,
            "anon",
            MINUS,
            v10,
            v25
        )())
        assertEquals(250, BinaryNumberExpr<Int>(
            root,
            "anon",
            MULTI,
            v10,
            v25
        )())
        assertEquals(2, BinaryNumberExpr<Int>(
            root,
            "anon",
            DIV,
            v25,
            v10
        )())
        assertEquals(5, BinaryNumberExpr<Int>(
            root,
            "anon",
            REMAINDER,
            v25,
            v10
        )())
    }

    @Test
    fun testBinaryBooleanExpressions() {
        val root = Item()
        val vTrue = of(true)
        val vFalse = of(false)

        assertEquals(true, BinaryLogicalExp(
            root,
            "anon",
            AND,
            vTrue,
            vTrue
        )())
        assertEquals(true, BinaryLogicalExp(
            root,
            "anon",
            OR,
            vTrue,
            vFalse
        )())
    }
}
