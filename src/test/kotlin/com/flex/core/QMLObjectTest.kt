package com.flex.core

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

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
class QMLObjectTest {

    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    fun createDynamicProperty() {
    }

    @Test
    fun parentInsertionTree() {

        val obj = QtObject(1, null)
        val left = QtObject(2, obj)
        val right = QtObject(3, obj)

        QtObject(4, left)
        QtObject(5, left)
        QtObject(6, right)


        assertNotNull(obj)
        assertEquals(2, obj.children.size)

        assertEquals(2, obj.getChildrenAt(0).id)
        assertEquals(3, obj.getChildrenAt(1).id)

        assertEquals(2, obj.getChildrenAt(0).children.size)
        assertEquals(4, left.getChildrenAt(0).id)
        assertEquals(5, left.getChildrenAt(1).id)


        assertEquals(1, obj.getChildrenAt(1).children.size)
        assertEquals(6, right.getChildrenAt(0).id)
    }

}