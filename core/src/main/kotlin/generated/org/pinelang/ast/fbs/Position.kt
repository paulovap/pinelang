// automatically generated by the FlatBuffers compiler, do not modify

package org.pinelang.ast.fbs

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
@ExperimentalUnsignedTypes
class Position : Struct() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : Position {
        __init(_i, _bb)
        return this
    }
    val line : Int get() = bb.getInt(bb_pos + 0)
    val char : Int get() = bb.getInt(bb_pos + 4)
    companion object {
        fun createPosition(builder: FlatBufferBuilder, line: Int, char: Int) : Int {
            builder.prep(4, 8)
            builder.putInt(char)
            builder.putInt(line)
            return builder.offset()
        }
    }
}
