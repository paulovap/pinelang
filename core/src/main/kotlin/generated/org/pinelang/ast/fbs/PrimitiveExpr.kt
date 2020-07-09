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
class PrimitiveExpr : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): PrimitiveExpr {
    __init(_i, _bb)
    return this
  }
  val type: UByte
    get() {
      val o = __offset(4)
      return if (o != 0) bb.get(o + bb_pos).toUByte() else 0u
    }
  val value: Double
    get() {
      val o = __offset(6)
      return if (o != 0) bb.getDouble(o + bb_pos) else 0.0
    }
  val stringValue: String?
    get() {
      val o = __offset(8)
      return if (o != 0) __string(o + bb_pos) else null
    }
  val stringValueAsByteBuffer: ByteBuffer
    get() = __vector_as_bytebuffer(8, 1)
  fun stringValueInByteBuffer(_bb: ByteBuffer): ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsPrimitiveExpr(_bb: ByteBuffer): PrimitiveExpr =
        getRootAsPrimitiveExpr(_bb, PrimitiveExpr())
    fun getRootAsPrimitiveExpr(_bb: ByteBuffer, obj: PrimitiveExpr): PrimitiveExpr {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createPrimitiveExpr(
        builder: FlatBufferBuilder, type: UByte, value: Double, stringValueOffset: Int
    ): Int {
      builder.startTable(3)
      addValue(builder, value)
      addStringValue(builder, stringValueOffset)
      addType(builder, type)
      return endPrimitiveExpr(builder)
    }
    fun startPrimitiveExpr(builder: FlatBufferBuilder) = builder.startTable(3)
    fun addType(builder: FlatBufferBuilder, type: UByte) = builder.addByte(0, type.toByte(), 0)
    fun addValue(builder: FlatBufferBuilder, value: Double) = builder.addDouble(1, value, 0.0)
    fun addStringValue(builder: FlatBufferBuilder, stringValue: Int) =
        builder.addOffset(2, stringValue, 0)
    fun endPrimitiveExpr(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
