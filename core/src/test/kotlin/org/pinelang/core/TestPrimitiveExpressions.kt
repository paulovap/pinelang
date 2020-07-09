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

import kotlin.test.assertEquals
import org.junit.Test

class TestPrimitiveExpressions {

  class Item : PineObject(-1) {
    companion object {
      val meta = PineMetaObject("Item") { Item() }
    }

    override fun getMeta(): PineMetaObject = meta
  }

  @Test
  fun testBasicDependency() {
    val right = PineExpr(PineType.INT) { 10 }
    val left = PineExpr(PineType.INT, right) { right() }

    assertEquals(10, left())
    right.update { 42 }
    assertEquals(42, left())
  }

  @Test
  fun testMultipleDependencies() {
    val first = PineInt(1)
    val second = PineInt(2)

    val sum = PineInt(first, second) { first() + second() }

    assertEquals(1, first.listenerCount)
    assertEquals(1, second.listenerCount)

    assertEquals(3, sum())

    first.update { 10 }

    assertEquals(12, sum())
    assertEquals(1, first.listenerCount)
    assertEquals(1, second.listenerCount)

    second.update { 20 }

    assertEquals(30, sum())
    assertEquals(1, first.listenerCount)
    assertEquals(1, second.listenerCount)

    first.update { 1 }
    second.update { 1 }

    assertEquals(2, sum())
    assertEquals(1, first.listenerCount)
    assertEquals(1, second.listenerCount)

    sum.update { 5 }

    assertEquals(5, sum())
    assertEquals(0, first.listenerCount)
    assertEquals(0, second.listenerCount)
  }

  @Test
  fun testRecursiveDependency() {
    val first = PineInt(1)
    val second = PineInt(first) { first() }
    val third = PineInt(second) { second() }

    assertEquals(first(), third())

    first.update { 2 }

    assertEquals(2, third())
    assertEquals(2, second())
  }

  @Test
  fun testBindingAfterUse() {
    val first = PineInt(1)

    val second = PineInt(first) { first() }

    assertEquals(1, second())
    assertEquals(1, first.listenerCount)

    val third = PineInt(42)
    first.update(third) { third() }

    assertEquals(42, first())
    assertEquals(42, second())
    assertEquals(1, first.listenerCount)
  }

  @Test
  fun testChainBinding() {
    val first = PineInt(1)
    val second = PineInt(first) { first() }

    assertEquals(1, second())

    val third = PineInt(second) { second() }
    assertEquals(1, third())

    val fourth = PineInt(2)
    second.update(fourth) { fourth() }
    assertEquals(2, third())
  }

  @Test
  fun testExpressionArray() {

    var sumInt = 0
    val exprs =
        (0 until 10)
            .map {
              sumInt += it
              PineInt(it)
            }
            .toTypedArray()

    val sumExpr = PineInt(*exprs) { exprs.sumBy { it() } }

    assertEquals(sumInt, sumExpr())

    val expr4 = exprs[4]()
    exprs[4].update { expr4 + 42 }
    sumInt += 42
    assertEquals(sumInt, sumExpr())
  }

  @Test
  fun testIntExpr() {
    val a = intExpr(10)
    val b = intExpr(20)

    val sum = a + b
    val diff = a - b
    val multi = a * b
    val div = a / b
    val remainder = a % b

    assertEquals(10, a())
    assertEquals(20, b())
    assertEquals(30, sum())
    assertEquals(-10, diff())
    assertEquals(200, multi())
    assertEquals(1 / 2, div())
    assertEquals(10 % 20, remainder())

    a.update { 2 }

    assertEquals(2, a())
    assertEquals(20, b())
    assertEquals(22, sum())
    assertEquals(-18, diff())
    assertEquals(40, multi())
    assertEquals(2 / 20, div())
    assertEquals(2 % 20, remainder())

    b.update { 3 }

    assertEquals(2, a())
    assertEquals(3, b())
    assertEquals(5, sum())
    assertEquals(-1, diff())
    assertEquals(6, multi())
    assertEquals(2 / 3, div())
    assertEquals(2 % 3, remainder())
  }

  @Test
  fun testBoolExpressions() {
    val first = PineBoolean(true)
    val second = PineBoolean(false)

    val and = PineBoolean(first, second) { first() && second() }
    val or = PineBoolean(first, second) { first() || second() }

    assertEquals(true, first())
    assertEquals(false, second())

    assertEquals(false, and())
    assertEquals(true, or())

    second.update { true }

    assertEquals(true, and())
    assertEquals(true, or())

    first.update { false }
    second.update { false }

    assertEquals(false, and())
    assertEquals(false, or())
  }
  /*
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
  */
}
