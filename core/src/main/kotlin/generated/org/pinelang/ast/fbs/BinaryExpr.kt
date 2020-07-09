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
class BinaryExpr : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): BinaryExpr {
    __init(_i, _bb)
    return this
  }
  val op: UByte
    get() {
      val o = __offset(4)
      return if (o != 0) bb.get(o + bb_pos).toUByte() else 0u
    }
  val left: org.pinelang.ast.fbs.Expr?
    get() = left(org.pinelang.ast.fbs.Expr())
  fun left(obj: org.pinelang.ast.fbs.Expr): org.pinelang.ast.fbs.Expr? {
    val o = __offset(6)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  val right: org.pinelang.ast.fbs.Expr?
    get() = right(org.pinelang.ast.fbs.Expr())
  fun right(obj: org.pinelang.ast.fbs.Expr): org.pinelang.ast.fbs.Expr? {
    val o = __offset(8)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsBinaryExpr(_bb: ByteBuffer): BinaryExpr = getRootAsBinaryExpr(_bb, BinaryExpr())
    fun getRootAsBinaryExpr(_bb: ByteBuffer, obj: BinaryExpr): BinaryExpr {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createBinaryExpr(
        builder: FlatBufferBuilder, op: UByte, leftOffset: Int, rightOffset: Int
    ): Int {
      builder.startTable(3)
      addRight(builder, rightOffset)
      addLeft(builder, leftOffset)
      addOp(builder, op)
      return endBinaryExpr(builder)
    }
    fun startBinaryExpr(builder: FlatBufferBuilder) = builder.startTable(3)
    fun addOp(builder: FlatBufferBuilder, op: UByte) = builder.addByte(0, op.toByte(), 0)
    fun addLeft(builder: FlatBufferBuilder, left: Int) = builder.addOffset(1, left, 0)
    fun addRight(builder: FlatBufferBuilder, right: Int) = builder.addOffset(2, right, 0)
    fun endBinaryExpr(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
