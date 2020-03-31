package com.pinescript.util

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