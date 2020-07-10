// automatically generated by the FlatBuffers compiler, do not modify

package org.pinelang.ast.fbs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class PropDefinition : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : PropDefinition {
        __init(_i, _bb)
        return this
    }
    val id : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    val value : org.pinelang.ast.fbs.Expr? get() = value(org.pinelang.ast.fbs.Expr())
    fun value(obj: org.pinelang.ast.fbs.Expr) : org.pinelang.ast.fbs.Expr? {
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
        fun getRootAsPropDefinition(_bb: ByteBuffer): PropDefinition = getRootAsPropDefinition(_bb, PropDefinition())
        fun getRootAsPropDefinition(_bb: ByteBuffer, obj: PropDefinition): PropDefinition {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createPropDefinition(builder: FlatBufferBuilder, id: UByte, valueOffset: Int, debugOffset: Int) : Int {
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
        fun endPropDefinition(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
