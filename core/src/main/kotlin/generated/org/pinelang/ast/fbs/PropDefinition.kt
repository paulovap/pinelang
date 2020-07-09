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
class PropDefinition : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): PropDefinition {
    __init(_i, _bb)
    return this
  }
  val id: UByte
    get() {
      val o = __offset(4)
      return if (o != 0) bb.get(o + bb_pos).toUByte() else 0u
    }
  val value: org.pinelang.ast.fbs.Expr?
    get() = value(org.pinelang.ast.fbs.Expr())
  fun value(obj: org.pinelang.ast.fbs.Expr): org.pinelang.ast.fbs.Expr? {
    val o = __offset(6)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  val debug: org.pinelang.ast.fbs.DebugInfo?
    get() = debug(org.pinelang.ast.fbs.DebugInfo())
  fun debug(obj: org.pinelang.ast.fbs.DebugInfo): org.pinelang.ast.fbs.DebugInfo? {
    val o = __offset(8)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsPropDefinition(_bb: ByteBuffer): PropDefinition =
        getRootAsPropDefinition(_bb, PropDefinition())
    fun getRootAsPropDefinition(_bb: ByteBuffer, obj: PropDefinition): PropDefinition {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createPropDefinition(
        builder: FlatBufferBuilder, id: UByte, valueOffset: Int, debugOffset: Int
    ): Int {
      builder.startTable(3)
      addDebug(builder, debugOffset)
      addValue(builder, valueOffset)
      addId(builder, id)
      return endPropDefinition(builder)
    }
    fun startPropDefinition(builder: FlatBufferBuilder) = builder.startTable(3)
    fun addId(builder: FlatBufferBuilder, id: UByte) = builder.addByte(0, id.toByte(), 0)
    fun addValue(builder: FlatBufferBuilder, value: Int) = builder.addOffset(1, value, 0)
    fun addDebug(builder: FlatBufferBuilder, debug: Int) = builder.addOffset(2, debug, 0)
    fun endPropDefinition(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
