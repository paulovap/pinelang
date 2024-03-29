// automatically generated by the FlatBuffers compiler, do not modify

package org.pinelang.ast.fbs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class PrimitiveExpr : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : PrimitiveExpr {
        __init(_i, _bb)
        return this
    }
    val type : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val value : Double
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getDouble(o + bb_pos) else 0.0
        }
    val stringValue : String?
        get() {
            val o = __offset(8)
            return if (o != 0) __string(o + bb_pos) else null
        }
    val stringValueAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 1)
    fun stringValueInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 1)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_1_12_0()
        fun getRootAsPrimitiveExpr(_bb: ByteBuffer): PrimitiveExpr = getRootAsPrimitiveExpr(_bb, PrimitiveExpr())
        fun getRootAsPrimitiveExpr(_bb: ByteBuffer, obj: PrimitiveExpr): PrimitiveExpr {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createPrimitiveExpr(builder: FlatBufferBuilder, type: UByte, value: Double, stringValueOffset: Int) : Int {
            builder.startTable(3)
            addValue(builder, value)
            addStringValue(builder, stringValueOffset)
            addType(builder, type)
            return endPrimitiveExpr(builder)
        }
        fun startPrimitiveExpr(builder: FlatBufferBuilder) = builder.startTable(3)
        fun addType(builder: FlatBufferBuilder, type: UByte) = builder.addByte(0, type.toByte(), 0)
        fun addValue(builder: FlatBufferBuilder, value: Double) = builder.addDouble(1, value, 0.0)
        fun addStringValue(builder: FlatBufferBuilder, stringValue: Int) = builder.addOffset(2, stringValue, 0)
        fun endPrimitiveExpr(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
