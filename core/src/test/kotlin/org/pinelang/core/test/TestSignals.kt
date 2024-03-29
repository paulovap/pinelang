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
import org.junit.After
import org.junit.Before
import org.junit.Test

class TestSignals {

  @Before
  @Throws(Exception::class)
  fun setUp() {}

  @After
  @Throws(Exception::class)
  fun tearDown() {}

  @Test
  fun testConnections() {
    val root = Item(-1)
    var count = 0
    val slot: () -> Unit = { count++ }
    root.connect("myInt", slot)
    root.connect("myInt", slot)
    root.myInt = 1
    root.myInt = 2
    root.myInt = 3
    assertEquals(6, count)
    root.disconnect("myInt", slot)
    root.myInt = 4
    assertEquals(7, count)
    root.connect("myInt", slot)
    root.myInt = 5
    assertEquals(9, count)
    assertEquals(9, count)
  }
}
