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
package org.pinelang.util

import org.pinelang.core.PineScriptException

class IndexedMap<V>(
    initialCapacity: Int = 10,
    val index: MutableMap<String, Int> = HashMap(initialCapacity),
    private val props: MutableList<V> = ArrayList(initialCapacity)
) {

  val size: Int
    get() = props.size

  fun getIndex(key: String): Int = getIndexOrNull(key)!!
  fun getIndexOrNull(key: String): Int? = index[key]

  fun getValue(key: String): V = this[key]!!
  fun getValue(index: Int): V = props[index]

  operator fun get(idx: Int): V? = props.getOrNull(idx)
  operator fun get(key: String): V? = getIndexOrNull(key)?.let { getValue(it) }

  operator fun set(key: String, value: V): IndexedMap<V> {
    if (index.containsKey(key)) throw PineScriptException("key $key already exists")
    props.add(value)
    index[key] = props.size - 1
    return this
  }

  operator fun contains(key: String): Boolean = getIndexOrNull(key) != null
}
