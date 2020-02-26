package com.flex.core

import java.util.LinkedHashMap

interface QMLObject {

    var id: Long
    var children: MutableList<QMLObject>
    val declaredProperties: MutableList<QMLProperty>

    fun getChildrenAt(pos: Int): QMLObject

    fun getParent(parent: QMLObject): QMLObject

    fun setParent(parent: QMLObject?)

    fun addDynamicProperty(property: QMLProperty)

    fun connect(propertyName: String, slot: () -> Unit = {})

    fun disconnect(propertyName: String, slot: () -> Unit = {})

    fun getProperty(name: String): QMLProperty?


    fun dumpObjectTree(): String? {
        return null
    }

    // This should be package private
    fun addChild(child: QMLObject)

    // This should be package private
    fun removeChild(child: QMLObject)
}