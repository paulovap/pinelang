package org.pinelang.util

import org.pinelang.core.PineSignal

fun <K, V> MutableMap<K, MutableSet<V>>.safeAdd(key: K, value: V) {
    var list = this[key]
    if (list == null) {
        list = mutableSetOf()
        this[key] = list
    }
    list.add(value)
}

fun <K, V> MutableMap<K, MutableSet<V>>.safeGet(key: K): MutableSet<V> {
    var list = this[key]

    if (list == null) {
        list = mutableSetOf()
        this[key] = list
    }
    return list
}

fun List<PineSignal>.toIndexMap(): Map<String, Int> {
    var count = 0
    return this.associateBy({ it.getScriptName() }, { count++ })
}
