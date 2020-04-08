package com.pinescript.core

import com.pinescript.util.toIndexMap
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class Item(id: Int): PineObject(id) {
    companion object {
        val meta = PineMetaObject("Item") {Item(it)}
    }
    var myInt: Int by intProp(::myInt)
    var myDouble: Double by doubleProp(::myDouble)
    var myString: String by stringProp(::myString)
    override fun getMeta(): PineMetaObject = meta
}

class TestLang {

    val engine = PineEngine.Builder()
        .registerPineType(PineMetaObject("Item") {Item(it)})
        .build()

        @Before
    fun setup() {

    }

    @Test
    fun testPrimitives() {

        val item = engine.load("""
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

        val item = engine.load("""
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
        val itmm = Item(-1)
        val item = engine.load("""
            Item {
                myInt: 0.1 + 25
                myDouble: 1 + 0.0098
             //   myString: "asdf" + "fdsa"
            }
        """.trimIndent()) as Item

        assertEquals(25, item.myInt)
        assertEquals(1.0098, item.myDouble)
//        assertEquals("child2", (item.children.get(1) as Item).myString)
    }
}