// automatically generated by the FlatBuffers compiler, do not modify

package org.pinelang.ast.fbs

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
    val expr : org.pinelang.ast.fbs.CallableExpr? get() = expr(org.pinelang.ast.fbs.CallableExpr())
    fun expr(obj: org.pinelang.ast.fbs.CallableExpr) : org.pinelang.ast.fbs.CallableExpr? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val debug : org.pinelang.ast.fbs.DebugInfo? get() = debug(org.pinelang.ast.fbs.DebugInfo())
    fun debug(obj: org.pinelang.ast.fbs.DebugInfo) : org.pinelang.ast.fbs.DebugInfo? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
        fun getRootAsSignalExpr(_bb: ByteBuffer): SignalExpr = getRootAsSignalExpr(_bb, SignalExpr())
        fun getRootAsSignalExpr(_bb: ByteBuffer, obj: SignalExpr): SignalExpr {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createSignalExpr(builder: FlatBufferBuilder, id: UByte, exprOffset: Int, debugOffset: Int) : Int {
            builder.startTable(3)
            addDebug(builder, debugOffset)
            addExpr(builder, exprOffset)
            addId(builder, id)
            return endSignalExpr(builder)
        }
        fun startSignalExpr(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addId(builder: FlatBufferBuilder, id: UByte) = builder.addByte(0, id.toByte(), 0)
        fun addExpr(builder: FlatBufferBuilder, expr: Int) = builder.addOffset(1, expr, 0)
        fun addDebug(builder: FlatBufferBuilder, debug: Int) = builder.addOffset(2, debug, 0)
        fun endSignalExpr(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
