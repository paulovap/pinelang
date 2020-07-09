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
class PropRefExpr : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): PropRefExpr {
    __init(_i, _bb)
    return this
  }
  val objId: Int
    get() {
      val o = __offset(4)
      return if (o != 0) bb.getInt(o + bb_pos) else 0
    }
  val propId: UByte
    get() {
      val o = __offset(6)
      return if (o != 0) bb.get(o + bb_pos).toUByte() else 0u
    }
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsPropRefExpr(_bb: ByteBuffer): PropRefExpr =
        getRootAsPropRefExpr(_bb, PropRefExpr())
    fun getRootAsPropRefExpr(_bb: ByteBuffer, obj: PropRefExpr): PropRefExpr {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createPropRefExpr(builder: FlatBufferBuilder, objId: Int, propId: UByte): Int {
      builder.startTable(2)
      addObjId(builder, objId)
      addPropId(builder, propId)
      return endPropRefExpr(builder)
    }
    fun startPropRefExpr(builder: FlatBufferBuilder) = builder.startTable(2)
    fun addObjId(builder: FlatBufferBuilder, objId: Int) = builder.addInt(0, objId, 0)
    fun addPropId(builder: FlatBufferBuilder, propId: UByte) =
        builder.addByte(1, propId.toByte(), 0)
    fun endPropRefExpr(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
