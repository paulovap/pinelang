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
class DebugInfo : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): DebugInfo {
    __init(_i, _bb)
    return this
  }
  val range: org.pinelang.ast.fbs.Range?
    get() = range(org.pinelang.ast.fbs.Range())
  fun range(obj: org.pinelang.ast.fbs.Range): org.pinelang.ast.fbs.Range? {
    val o = __offset(4)
    return if (o != 0) {
      obj.__assign(o + bb_pos, bb)
    } else {
      null
    }
  }
  val debugName: String?
    get() {
      val o = __offset(6)
      return if (o != 0) __string(o + bb_pos) else null
    }
  val debugNameAsByteBuffer: ByteBuffer
    get() = __vector_as_bytebuffer(6, 1)
  fun debugNameInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 6, 1)
  val debugType: String?
    get() {
      val o = __offset(8)
      return if (o != 0) __string(o + bb_pos) else null
    }
  val debugTypeAsByteBuffer: ByteBuffer
    get() = __vector_as_bytebuffer(8, 1)
  fun debugTypeInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsDebugInfo(_bb: ByteBuffer): DebugInfo = getRootAsDebugInfo(_bb, DebugInfo())
    fun getRootAsDebugInfo(_bb: ByteBuffer, obj: DebugInfo): DebugInfo {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun startDebugInfo(builder: FlatBufferBuilder) = builder.startTable(3)
    fun addRange(builder: FlatBufferBuilder, range: Int) = builder.addStruct(0, range, 0)
    fun addDebugName(builder: FlatBufferBuilder, debugName: Int) =
        builder.addOffset(1, debugName, 0)
    fun addDebugType(builder: FlatBufferBuilder, debugType: Int) =
        builder.addOffset(2, debugType, 0)
    fun endDebugInfo(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
