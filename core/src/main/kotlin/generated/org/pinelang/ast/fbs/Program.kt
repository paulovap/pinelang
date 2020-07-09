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
package org.pinelang.ast.fbs

import com.google.flatbuffers.*
import java.nio.*
import kotlin.math.sign

@Suppress("unused")
@ExperimentalUnsignedTypes
class Program : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): Program {
    __init(_i, _bb)
    return this
  }
  val root: org.pinelang.ast.fbs.ObjectDefinition?
    get() = root(org.pinelang.ast.fbs.ObjectDefinition())
  fun root(obj: org.pinelang.ast.fbs.ObjectDefinition): org.pinelang.ast.fbs.ObjectDefinition? {
    val o = __offset(4)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsProgram(_bb: ByteBuffer): Program = getRootAsProgram(_bb, Program())
    fun getRootAsProgram(_bb: ByteBuffer, obj: Program): Program {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createProgram(builder: FlatBufferBuilder, rootOffset: Int): Int {
      builder.startTable(1)
      addRoot(builder, rootOffset)
      return endProgram(builder)
    }
    fun startProgram(builder: FlatBufferBuilder) = builder.startTable(1)
    fun addRoot(builder: FlatBufferBuilder, root: Int) = builder.addOffset(0, root, 0)
    fun endProgram(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
    fun finishProgramBuffer(builder: FlatBufferBuilder, offset: Int) = builder.finish(offset)
    fun finishSizePrefixedProgramBuffer(builder: FlatBufferBuilder, offset: Int) =
        builder.finishSizePrefixed(offset)
  }
}
