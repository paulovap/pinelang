package com.flex.core

import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class PineSignal {

    private val slots = CopyOnWriteArrayList<() -> Unit>()

    private val enabled = AtomicBoolean(true)

    /**
     * Execute all Slots.
     */
    fun emit() {
        if (!enabled.get())
            return

        for (each in slots) {
            each()
        }
    }

    /**
     * Connect a Slot to a signal.<br></br>
     * Add a Slot to the ArrayList.
     * @param slot the Slot to be added
     */
    fun connect(slot: () -> Unit) {
        slots.add(slot)
    }

    /**
     * Disconnect a Slot from a signal.<br></br>
     * Remove a Slot from the ArrayList.
     * @param slot the Slot to be removed
     */
    fun disconnect(slot: () -> Unit) {
        slots.remove(slot)
    }

    fun disconnectAll() {
        slots.clear()
    }

}

open class PineObject(val id: Long = -1) {

    val children: MutableList<PineObject> = mutableListOf()
    val kProps = mutableMapOf<KProperty<*>, PineProp<*>>()
    val nameProps = mutableMapOf<String, PineProp<*>>()

    val childrenChanged = PineSignal()

    fun getChildrenAt(pos: Int): PineObject {
        return children[pos]
    }

    fun getProp(kProp: KProperty<*>): PineProp<*> {
        return kProps[kProp] ?: throw QMLRuntimeException("Prop ${kProp.name} not found")
    }

    fun getProp(name: String): PineProp<*>? {
        return nameProps[name]
    }

    fun dumpObjectTree(): String? {
        return null
    }

    // This should be package private
    fun addChild(child: PineObject) {
        if (this.children.contains(child)) {
            return
        }
        this.children.add(child)
        childrenChanged.emit()
    }

    // This should be package private
    fun removeChild(child: PineObject) {
        this.children.remove(child)
        childrenChanged.emit()
    }

    fun intProp(kProp: KProperty<Int>, scriptName: String? = null, initialValue: Int = 0, slot:(() -> Unit)? = null) =
        makePineProp(PineType.INT, kProp, scriptName?:kProp.name, initialValue, slot)

    fun boolProp(kProp: KProperty<Boolean>, scriptName: String? = null,  initialValue: Boolean = false, slot:(() -> Unit)? = null) =
        makePineProp(PineType.BOOL, kProp, scriptName?:kProp.name, initialValue, slot)

    fun stringProp(kProp: KProperty<String>, scriptName: String? = null,  initialValue: String = "", slot:(() -> Unit)? = null) =
        makePineProp(PineType.STRING, kProp, scriptName?:kProp.name, initialValue, slot)

    fun doubleProp(kProp: KProperty<Double>, scriptName: String? = null,  initialValue: Double = 0.0, slot:(() -> Unit)? = null) =
        makePineProp(PineType.DOUBLE, kProp, scriptName?:kProp.name, initialValue, slot)

    fun <T> makePineProp(type: PineType, kProp: KProperty<T>, scriptName: String = kProp.name,  initialValue: T, slot:(() -> Unit)? = null): PineProp<T> {
        if (nameProps.containsKey(scriptName))
            throw QMLRuntimeException("Property of name $scriptName already exists for type ${PineObject::javaClass::name}")
        return PineProp(type, kProp, initialValue).also { sig ->
            slot?.let { sig.connect(it) }
            nameProps[scriptName] = sig
            kProps[kProp] = sig
        }
    }

}