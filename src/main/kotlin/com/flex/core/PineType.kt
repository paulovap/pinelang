package com.flex.core

data class PineType(val typeName: String, val type: Int) {

    companion object {
        val BOOL   = PineType("Bool",0)
        val INT    = PineType("Int", 1)
        val DOUBLE  = PineType("Double",2)
        val STRING = PineType("String", 3)
        val OBJECT = PineType("Object", 4)

        inline fun <reified T> forType(): PineType {
            return when {
                0 is T -> INT
                Double.MAX_VALUE is T -> DOUBLE
                true is T -> BOOL
                else -> OBJECT
            }
        }
    }
}

