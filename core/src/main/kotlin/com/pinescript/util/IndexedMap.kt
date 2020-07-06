package com.pinescript.util

import com.pinescript.core.PineScriptException

class IndexedMap<V>(
    initialCapacity: Int = 10,
    val index: MutableMap<String, Int> = HashMap(initialCapacity),
    private val props: MutableList<V> = ArrayList(initialCapacity)
) {

    val size: Int
        get() = props.size

    fun getIndex(key: String): Int = getIndexOrNull(key)!!
    fun getIndexOrNull(key: String): Int? = index[key]

    fun getValue(key: String): V = this[key]!!
    fun getValue(index: Int): V = props[index]

    operator fun get(idx: Int): V? = props.getOrNull(idx)
    operator fun get(key: String): V? = getIndexOrNull(key)?.let { getValue(it) }

    operator fun set(key: String, value: V): IndexedMap<V> {
        if (index.containsKey(key))
            throw PineScriptException("key $key already exists")
        props.add(value)
        index[key] = props.size - 1
        return this
    }

    operator fun contains(key: String): Boolean = getIndexOrNull(key) != null
}
