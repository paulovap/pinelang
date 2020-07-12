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
package org.pinelang.core.test

import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import org.pinelang.core.*

class Item(id: Int) : PineObject(id) {
  companion object {
    val meta = PineMetaObject("Item") { Item(it) }
  }
  var myInt: Int by intProp(::myInt)
  var myDouble: Double by doubleProp(::myDouble)
  var myString: String by stringProp(::myString)
  var myBoolean: Boolean by boolProp(::myBoolean)
  override fun getMeta(): PineMetaObject = meta
}

class TestLang {

  val engine = PineEngine.Builder().registerPineType(PineMetaObject("Item") { Item(it) }).build()

  @Before fun setup() {}

  @Test
  fun testPrimitives() {

    val item =
        engine.load(
            """
            Item {
                myInt: 22dp
                myDouble: 23.23456
                myString: "that is a text 😀"
            }
        """.trimIndent()) as Item

    assertEquals(22, item.myInt)
    assertEquals(23.23456, item.myDouble)
    assertEquals("that is a text 😀", item.myString)
  }

  @Test
  fun testChildren() {

    val item =
        engine.load(
            """
            Item {
                Item { 
                    myString: "child1"
                    Item { myInt: 15; myString: "child1_1" }
                }
                
                Item { myString: "child2" }
            }
        """.trimIndent()) as Item

    assertEquals("child1", (item.children.get(0) as Item).myString)
    assertEquals("child1_1", (item.children.get(0).children.get(0) as Item).myString)
    assertEquals("child2", (item.children.get(1) as Item).myString)
  }

  @Test
  fun testBinaryExpression() {
    val item =
        engine.load(
            """
            Item {
                myInt: 1
                myDouble: 1 + 0.0098
                myBoolean: myInt == myDouble
             //   myString: "asdf" + "fdsa"
            }
        """.trimIndent()) as Item

    assertEquals(1, item.myInt)
    assertEquals(1.0098, item.myDouble)
    assertEquals(false, item.myBoolean)
  }

  @Test
  fun testBindBinaryExpression() {
    val item =
        engine.load(
            """
            Item {
                id: root
                myInt: a.myInt + b.myInt
                
                Item {
                  id: a
                  myInt: 10
                }
                Item {
                  id: b
                  myInt: 25
                }
            }
        """.trimIndent()) as Item

    val a = item.children.get(0) as Item
    val b = item.children.get(1) as Item
    assertEquals(35, item.myInt)

    a.myInt = 12
    assertEquals(37, item.myInt)
    b.myInt = 12

    assertEquals(24, item.myInt)

    item.myInt = 10
    a.myInt = 20
    assertEquals(10, item.myInt)
    assertEquals(20, a.myInt)
    assertEquals(12, b.myInt)
  }

  @Test(expected = BinaryOpException::class)
  fun testInvalidBinaryExpression() {
    val item = engine.load("Item { id: root; myInt: 10 + \"test\" }")
  }
}
