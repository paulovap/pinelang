// automatically generated by the FlatBuffers compiler, do not modify

package org.pinelang.ast.fbs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class Range : Struct() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Range {
        __init(_i, _bb)
        return this
    }
    val start : org.pinelang.ast.fbs.Position? get() = start(org.pinelang.ast.fbs.Position())
    fun start(obj: org.pinelang.ast.fbs.Position) : org.pinelang.ast.fbs.Position? = obj.__assign(bb_pos + 0, bb)
    val end : org.pinelang.ast.fbs.Position? get() = end(org.pinelang.ast.fbs.Position())
    fun end(obj: org.pinelang.ast.fbs.Position) : org.pinelang.ast.fbs.Position? = obj.__assign(bb_pos + 8, bb)
    companion object {
        fun createRange(builder: FlatBufferBuilder, start_line: Int, start_char: Int, end_line: Int, end_char: Int) : Int {
            builder.prep(4, 16)
            builder.prep(4, 8)
            builder.putInt(end_char)
            builder.putInt(end_line)
            builder.prep(4, 8)
            builder.putInt(start_char)
            builder.putInt(start_line)
            return builder.offset()
        }
    }
}
