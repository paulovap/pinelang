package com.flex.core

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

data class PineType(val typeName: String, val type: Int) {
    companion object {
        val BOOL   = PineType("Bool",0)
        val INT    = PineType("Int", 1)
        val DOUBLE  = PineType("Double",2)
        val STRING = PineType("String", 3)
        val OBJECT = PineType("Object", 4)
    }
}

interface PineSignal {
    val slots: MutableList<() -> Unit>

    /**
     * Execute all Slots.
     */
    fun emit() = slots.forEach { it() }

    /**
     * Connect a Slot to a signal.<br></br>
     * Add a Slot to the ArrayList.
     * @param slot the Slot to be added
     */
    fun connect(slot: () -> Unit) = slots.add(slot)

    /**
     * Disconnect a Slot from a signal.<br></br>
     * Remove a Slot from the ArrayList.
     * @param slot the Slot to be removed
     */
    fun disconnect(slot: () -> Unit) = slots.remove(slot)

    fun disconnectAll() = slots.clear()
}

class BasicPineSignal : PineSignal {
    override val slots: MutableList<() -> Unit> = mutableListOf()
}

class PineProp<T>(val type: PineType, val kProp: KProperty<T>, initialValue: T) : PineSignal,
    ObservableProperty<T>(initialValue) {

    override val slots: MutableList<() -> Unit> = mutableListOf()
    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) = slots.forEach { it() }

    fun getValue(): T = getValue(this, kProp)
    fun setValue(value: T) = setValue(this, kProp, value)
    fun asBool(): PineProp<Boolean> = asType(PineType.BOOL)
    fun asDouble(): PineProp<Double> = asType(PineType.DOUBLE)
    fun asInt(): PineProp<Int> = asType(PineType.INT)
    fun asString(): PineProp<String> = asType(PineType.STRING)
    fun asObject(): PineProp<Any> = asType(PineType.OBJECT)

    private fun <X> asType(newType: PineType): PineProp<X> {
        if (newType != this.type) {
            throw PineScriptException("${newType.typeName} cannot be cast to ${this.type.typeName}")
        }
        return this as PineProp<X>
    }

}


open class PineObject(val id: Long = -1) {

    val children: MutableList<PineObject> = mutableListOf()
    val kProps = mutableMapOf<KProperty<*>, PineProp<*>>()
    val nameProps = mutableMapOf<String, PineProp<*>>()

    val childrenChanged = BasicPineSignal()

    fun getChildrenAt(pos: Int): PineObject = children[pos]
    fun getProp(kProp: KProperty<*>): PineProp<*> =
        kProps[kProp] ?: throw PineScriptException("Prop ${kProp.name} not found")

    fun getProp(name: String): PineProp<*>? = nameProps[name]
    fun dumpObjectTree(): String? = null

    fun addChild(child: PineObject) {
        if (this.children.contains(child)) {
            return
        }
        this.children.add(child)
        childrenChanged.emit()
    }

    fun removeChild(child: PineObject) {
        this.children.remove(child)
        childrenChanged.emit()
    }

    fun intProp(kProp: KProperty<Int>, scriptName: String? = null, initialValue: Int = 0, slot: (() -> Unit)? = null) =
        makePineProp(PineType.INT, kProp, scriptName ?: kProp.name, initialValue, slot)

    fun boolProp(
        kProp: KProperty<Boolean>,
        scriptName: String? = null,
        initialValue: Boolean = false,
        slot: (() -> Unit)? = null
    ) =
        makePineProp(PineType.BOOL, kProp, scriptName ?: kProp.name, initialValue, slot)

    fun stringProp(
        kProp: KProperty<String>,
        scriptName: String? = null,
        initialValue: String = "",
        slot: (() -> Unit)? = null
    ) =
        makePineProp(PineType.STRING, kProp, scriptName ?: kProp.name, initialValue, slot)

    fun doubleProp(
        kProp: KProperty<Double>,
        scriptName: String? = null,
        initialValue: Double = 0.0,
        slot: (() -> Unit)? = null
    ) =
        makePineProp(PineType.DOUBLE, kProp, scriptName ?: kProp.name, initialValue, slot)

    fun <T> makePineProp(
        type: PineType,
        kProp: KProperty<T>,
        scriptName: String = kProp.name,
        initialValue: T,
        slot: (() -> Unit)? = null
    ): PineProp<T> {
        if (nameProps.containsKey(scriptName))
            throw PineScriptException("Property of name $scriptName already exists for type ${PineObject::javaClass::name}")
        return PineProp(type, kProp, initialValue).also { sig ->
            slot?.let { sig.connect(it) }
            nameProps[scriptName] = sig
            kProps[kProp] = sig
        }
    }

}