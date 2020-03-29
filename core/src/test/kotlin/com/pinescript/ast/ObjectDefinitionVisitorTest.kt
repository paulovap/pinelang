/*
BSD License

Copyright (c) 2018, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
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

package com.pinescript.ast

import com.pinescript.core.*
import org.junit.After
import org.junit.Before
import org.junit.Test

import java.io.IOException

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull


class ObjectDefinitionVisitorTest {

    private var engine: PineEngine? = null

    class TestObject : PineObject(-1) {
        val myInt: Int by intProp(::myInt)
        var myDouble: Double by doubleProp(::myDouble)
        val myString: String by stringProp(::myString)
        val myBool: Boolean by boolProp(::myBool)
    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        engine = PineEngine.Builder()
            .registerPineType(PineMetaObject("TestObject") { TestObject() })
            .build()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

//    @Test
//    @Throws(IOException::class)
//    fun emptyObjectTest() {
//        val tree = LoadTree.loadTree("TestObject{}").objectDefinition()
//        val v = ObjectDefinitionVisitor(engine!!, QMLContext())
//        val obj = v.visit(tree)
//        assertNotNull(obj)
//    }
//
//    @Test
//    @Throws(IOException::class)
//    fun singleIntVariableObjectTest() {
//        val tree = LoadTree.loadTree("QtObject{ property int a: 10}").objectDefinition()
//        val v = ObjectDefinitionVisitor(engine!!, QMLContext())
//        val obj = v.visit(tree)
//        assertNotNull(obj)
//        assertEquals(10.toLong(), obj.getProp("a").getValue())
//    }

    @Test
    @Throws(IOException::class)
    fun testPrimivesAssignments() {
        val tree = LoadTree.loadTree(
            """
        TestObject { 
            double: 10.1; 
            string: "oh my"; 
            int: 20; 
            bool: true;
        }"""
        ).objectDefinition()
        val v = ObjectDefinitionVisitor(engine!!)
        val obj = v.visit(tree) as TestObject

        assertNotNull(obj)

        val propDouble = obj.getProp("double")
        assertEquals(10.1, propDouble.value)
        assertEquals(10.1, obj.myDouble, 0.01)

        val propString = obj.getProp("string")
        assertEquals("oh my", propString.value)
        assertEquals("oh my", obj.myString)

        val propInt = obj.getProp("int")
        assertEquals(20, propInt.value)
        assertEquals(20, obj.myInt)

        val propBool = obj.getProp("bool")
        assertEquals(true, propBool.value)
        assertEquals(true, obj.myBool)

    }
//
//    @Test
//    @Throws(IOException::class)
//    fun singleBooleanVariableObjectTest() {
//        val tree = LoadTree.loadTree("QtObject{ property bool a: true}").objectDefinition()
//        val v = ObjectDefinitionVisitor(engine!!, QMLContext())
//        val obj = v.visit(tree)
//        assertNotNull(obj)
//        assertEquals(true, obj.getProp("a").getValue())
//    }

//    @Test
//    @Throws(IOException::class)
//    fun singleStringVariableObjectTest() {
//        val tree = LoadTree.loadTree("QtObject{ property string a: 'cow'}").objectDefinition()
//        val v = ObjectDefinitionVisitor(engine!!, QMLContext())
//        val obj = v.visit(tree)
//        assertNotNull(obj)
//        assertEquals("cow", obj.getProp("a").getValue())
//    }

//    @Test
//    @Throws(IOException::class)
//    fun singleObjectVariableObjectTest() {
//        val tree = LoadTree.loadTree("QtObject{ a: 10 }").objectDefinition()
//        val v = ObjectDefinitionVisitor(engine!!, QMLContext())
//        val obj = v.visit(tree)
//        assertNotNull(obj)
//    }

}