// automatically generated by the FlatBuffers compiler, do not modify

package com.pinescript.ast.fbs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class SignalExpr : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : SignalExpr {
        __init(_i, _bb)
        return this
    }
    val id : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val expr : com.pinescript.ast.fbs.CallableExpr? get() = expr(com.pinescript.ast.fbs.CallableExpr())
    fun expr(obj: com.pinescript.ast.fbs.CallableExpr) : com.pinescript.ast.fbs.CallableExpr? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val debugName : String?
        get() {
            val o = __offset(8)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val debugNameAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun debugNameInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
        fun getRootAsSignalExpr(_bb: ByteBuffer): SignalExpr = getRootAsSignalExpr(_bb, SignalExpr())
        fun getRootAsSignalExpr(_bb: ByteBuffer, obj: SignalExpr): SignalExpr {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createSignalExpr(builder: FlatBufferBuilder, id: UByte, exprOffset: Int, debugNameOffset: Int) : Int {
            builder.startTable(3)
            addDebugName(builder, debugNameOffset)
            addExpr(builder, exprOffset)
            addId(builder, id)
            return endSignalExpr(builder)
        }
        fun startSignalExpr(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addId(builder: FlatBufferBuilder, id: UByte) = builder.addByte(0, id.toByte(), 0)
        fun addExpr(builder: FlatBufferBuilder, expr: Int) = builder.addOffset(1, expr, 0)
        fun addDebugName(builder: FlatBufferBuilder, debugName: Int) = builder.addOffset(2, debugName, 0)
        fun endSignalExpr(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
