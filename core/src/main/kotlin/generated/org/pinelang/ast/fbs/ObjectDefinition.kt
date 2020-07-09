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
class ObjectDefinition : Table() {

  fun __init(_i: Int, _bb: ByteBuffer) {
    __reset(_i, _bb)
  }
  fun __assign(_i: Int, _bb: ByteBuffer): ObjectDefinition {
    __init(_i, _bb)
    return this
  }
  val id: Int
    get() {
      val o = __offset(4)
      return if (o != 0) bb.getInt(o + bb_pos) else 0
    }
  val type: Int
    get() {
      val o = __offset(6)
      return if (o != 0) bb.getInt(o + bb_pos) else 0
    }
  fun children(j: Int): org.pinelang.ast.fbs.ObjectDefinition? =
      children(org.pinelang.ast.fbs.ObjectDefinition(), j)
  fun children(
      obj: org.pinelang.ast.fbs.ObjectDefinition, j: Int
  ): org.pinelang.ast.fbs.ObjectDefinition? {
    val o = __offset(8)
    return if (o != 0) {
      obj.__assign(__indirect(__vector(o) + j * 4), bb)
    } else {
      null
    }
  }
  val childrenLength: Int
    get() {
      val o = __offset(8)
      return if (o != 0) __vector_len(o) else 0
    }
  fun signals(j: Int): org.pinelang.ast.fbs.SignalExpr? =
      signals(org.pinelang.ast.fbs.SignalExpr(), j)
  fun signals(obj: org.pinelang.ast.fbs.SignalExpr, j: Int): org.pinelang.ast.fbs.SignalExpr? {
    val o = __offset(10)
    return if (o != 0) {
      obj.__assign(__indirect(__vector(o) + j * 4), bb)
    } else {
      null
    }
  }
  val signalsLength: Int
    get() {
      val o = __offset(10)
      return if (o != 0) __vector_len(o) else 0
    }
  fun props(j: Int): org.pinelang.ast.fbs.PropDefinition? =
      props(org.pinelang.ast.fbs.PropDefinition(), j)
  fun props(
      obj: org.pinelang.ast.fbs.PropDefinition, j: Int
  ): org.pinelang.ast.fbs.PropDefinition? {
    val o = __offset(12)
    return if (o != 0) {
      obj.__assign(__indirect(__vector(o) + j * 4), bb)
    } else {
      null
    }
  }
  val propsLength: Int
    get() {
      val o = __offset(12)
      return if (o != 0) __vector_len(o) else 0
    }
  val debug: org.pinelang.ast.fbs.DebugInfo?
    get() = debug(org.pinelang.ast.fbs.DebugInfo())
  fun debug(obj: org.pinelang.ast.fbs.DebugInfo): org.pinelang.ast.fbs.DebugInfo? {
    val o = __offset(14)
    return if (o != 0) {
      obj.__assign(__indirect(o + bb_pos), bb)
    } else {
      null
    }
  }
  companion object {
    fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
    fun getRootAsObjectDefinition(_bb: ByteBuffer): ObjectDefinition =
        getRootAsObjectDefinition(_bb, ObjectDefinition())
    fun getRootAsObjectDefinition(_bb: ByteBuffer, obj: ObjectDefinition): ObjectDefinition {
      _bb.order(ByteOrder.LITTLE_ENDIAN)
      return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
    }
    fun createObjectDefinition(
        builder: FlatBufferBuilder,
        id: Int,
        type: Int,
        childrenOffset: Int,
        signalsOffset: Int,
        propsOffset: Int,
        debugOffset: Int
    ): Int {
      builder.startTable(6)
      addDebug(builder, debugOffset)
      addProps(builder, propsOffset)
      addSignals(builder, signalsOffset)
      addChildren(builder, childrenOffset)
      addType(builder, type)
      addId(builder, id)
      return endObjectDefinition(builder)
    }
    fun startObjectDefinition(builder: FlatBufferBuilder) = builder.startTable(6)
    fun addId(builder: FlatBufferBuilder, id: Int) = builder.addInt(0, id, 0)
    fun addType(builder: FlatBufferBuilder, type: Int) = builder.addInt(1, type, 0)
    fun addChildren(builder: FlatBufferBuilder, children: Int) = builder.addOffset(2, children, 0)
    fun createChildrenVector(builder: FlatBufferBuilder, data: IntArray): Int {
      builder.startVector(4, data.size, 4)
      for (i in data.size - 1 downTo 0) {
        builder.addOffset(data[i])
      }
      return builder.endVector()
    }
    fun startChildrenVector(builder: FlatBufferBuilder, numElems: Int) =
        builder.startVector(4, numElems, 4)
    fun addSignals(builder: FlatBufferBuilder, signals: Int) = builder.addOffset(3, signals, 0)
    fun createSignalsVector(builder: FlatBufferBuilder, data: IntArray): Int {
      builder.startVector(4, data.size, 4)
      for (i in data.size - 1 downTo 0) {
        builder.addOffset(data[i])
      }
      return builder.endVector()
    }
    fun startSignalsVector(builder: FlatBufferBuilder, numElems: Int) =
        builder.startVector(4, numElems, 4)
    fun addProps(builder: FlatBufferBuilder, props: Int) = builder.addOffset(4, props, 0)
    fun createPropsVector(builder: FlatBufferBuilder, data: IntArray): Int {
      builder.startVector(4, data.size, 4)
      for (i in data.size - 1 downTo 0) {
        builder.addOffset(data[i])
      }
      return builder.endVector()
    }
    fun startPropsVector(builder: FlatBufferBuilder, numElems: Int) =
        builder.startVector(4, numElems, 4)
    fun addDebug(builder: FlatBufferBuilder, debug: Int) = builder.addOffset(5, debug, 0)
    fun endObjectDefinition(builder: FlatBufferBuilder): Int {
      val o = builder.endTable()
      return o
    }
  }
}
