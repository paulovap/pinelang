// automatically generated by the FlatBuffers compiler, do not modify

package com.pinescript.fbs.ast

@Suppress("unused")
@ExperimentalUnsignedTypes
class Expr private constructor() {
    companion object {
        const val NONE: UByte = 0u
        const val CallableExpr: UByte = 1u
        const val BinaryExpr: UByte = 2u
        const val PrimitiveExpr: UByte = 3u
        val names : Array<String> = arrayOf("NONE", "CallableExpr", "BinaryExpr", "PrimitiveExpr")
        fun name(e: Int) : String = names[e]
    }
}
