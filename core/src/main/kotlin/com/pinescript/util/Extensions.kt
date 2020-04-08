package com.pinescript.util

import com.pinescript.core.PineCallable
import com.pinescript.core.PineSignal
import java.util.zip.CRC32

fun String.crc32(): Long {
    val bytes = this.toByteArray()
    val checksum = CRC32()
    checksum.update(bytes, 0, bytes.size)
    return checksum.value
}

fun <K, V>MutableMap<K, MutableSet<V>>.safeSet(key: K, value: V) {
    var list = this[key]
    if (list == null) {
        list = mutableSetOf()
        this[key] = list
    }
    list.add(value)
}

fun <K, V>MutableMap<K, MutableSet<V>>.safeGet(key: K): MutableSet<V> {
    var list = this[key]

    if (list == null) {
        list = mutableSetOf()
        this[key] = list
    }
    return list
}

fun List<PineSignal>.toIndexMap(): Map<String, Int> {
    var count = 0;
    return this.associateBy({it.getScriptName()}, {count++})
}