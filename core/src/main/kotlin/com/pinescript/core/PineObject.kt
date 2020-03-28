package com.pinescript.core

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Slot = () -> Unit

interface PineSignal {

    fun getScriptName(): String
    val signalName: String
        get() = "on" + getScriptName().capitalize()

    val slots: MutableSet<Slot>

    /**
     * Execute all Slots.
     */
    fun emit() = slots.forEach { it() }

    /**
     * Connect a Slot to a signal.<br></br>
     * Add a Slot to the ArrayList.
     * @param slot the Slot to be added
     */
    fun connect(slot: Slot) = slots.add(slot)

    /**
     * Disconnect a Slot from a signal.<br></br>
     * Remove a Slot from the ArrayList.
     * @param slot the Slot to be removed
     */
    fun disconnect(slot: Slot) = slots.remove(slot)

    fun disconnectAll() = slots.clear()
}

class BaseSignal(val name: String) : PineSignal {
    override fun getScriptName(): String = name
    override val slots: MutableSet<Slot> = mutableSetOf()
}

class PineProp<T>(
    val name: String,
    val pineType: PineType,
    val kProp: KProperty<*>,
    initialValue: PineValue<T>, slot: Slot?
) : PineSignal, ReadWriteProperty<PineObject, T> {

    override val slots = mutableSetOf<Slot>()

    var value: PineValue<T> = initialValue
        set(value) {
            if (field != value) {
                field = value
                emit()
            }
        }

    init {
        slot?.also { slots.add(it) }
    }

    override fun getScriptName(): String = name

    override fun getValue(thisRef: PineObject, property: KProperty<*>): T {
        return value.getValue()
    }

    override fun setValue(thisRef: PineObject, property: KProperty<*>, value: T) {
        this.value = PineValue.of(value) as PineValue<T>
    }

    fun setPineValue(value: PineValue<*>) {
        this.value = value as PineValue<T>
    }

    fun bind(otherProp: PineProp<*>) {
        checkType(otherProp)
        when (pineType) {
            PineType.DOUBLE -> otherProp.connect { this.asType<Double>().value = otherProp.asType<Double>().value }
            PineType.STRING -> otherProp.connect { this.asType<String>().value = otherProp.asType<String>().value }
            PineType.INT -> otherProp.connect { this.asType<Int>().value = otherProp.asType<Int>().value }
            PineType.OBJECT -> otherProp.connect { this.asType<Any>().value = otherProp.asType<Any>().value }
        }
        otherProp.emit()
    }

    private fun checkType(other: PineProp<*>): PineProp<*> {
        if (other.pineType != this.pineType)
            throw PineScriptParseException("unable to bind prop $other into ${this}. Incompatible types}")
        return this
    }

    fun <T> asType(): PineProp<T> = this as PineProp<T>
}

open class ListPineProp<T>(val name: String, initialSlot: (Slot)? = null) : PineSignal, Iterable<T> {

    init {
        initialSlot?.also { connect(it) }
    }

    var props = mutableListOf<T>()

    fun add(el: T) = props.add(el).apply { emit() }

    fun remove(el: T) = props.remove(el).apply { emit() }

    fun get(pos: Int): T {
        return props[pos]
    }

    override fun getScriptName(): String = name

    override val slots: MutableSet<Slot> = mutableSetOf()

    override fun iterator(): Iterator<T> = ListPinePropIterator()

    inner class ListPinePropIterator : Iterator<T> {
        private var pos = 0
        override fun hasNext(): Boolean = pos < props.size
        override fun next(): T = props[pos++]
    }
}

open class PineObject(val id: Long = -1) {

    // Children objects
    val children: ListPineProp<PineObject> = ListPineProp("children")

    // All Object properties accessible to the script
    val nameProps = mutableMapOf<String, PineProp<*>>()

    // All "events" that can be fired by an object to a script
    val signals = mutableMapOf(
        makeSignal(SIG_MOUNT),
        makeSignal(SIG_UNMOUNT)
    )

    // All functions that can be called from script
    val callables = mutableMapOf(
        makeCallable("printHello") { println("Hello world") },
        makeCallable("helloText")  { "Hello world" }
    )



    init {
        signals[SIG_MOUNT]?.connect { println("Did mount for object $this") }
        signals[SIG_UNMOUNT]?.connect { println("Did unmount for object $this") }
    }

    fun emitMount() {
        signals[SIG_MOUNT]?.emit()
        children.forEach { it.emitMount() }
    }
    fun emitUnmount() {
        children.forEach { it.dispose() }
        signals[SIG_UNMOUNT]?.emit()
    }

    fun connect(propName: String, slot: Slot) {
        val prop = nameProps[propName] ?: throw PineScriptException("prop $propName not found")
        prop.connect(slot)
    }

    fun getProp(name: String): PineProp<*>? = nameProps[name]

    fun dispose() {
        emitUnmount()
    }

    companion object {
        const val SIG_MOUNT = "mount"
        const val SIG_UNMOUNT = "unmount"
    }

    fun makeSignal(name: String): Pair<String, BaseSignal> = name to BaseSignal(name)
    fun <T>makeCallable(name: String, lambda: () -> T): Pair<String, ExprValue<*>> = name to ExprValue<T>(lambda)
}


fun PineObject.intProp(
    kProp: KProperty<Int>,
    initialValue: Int = 0,
    slot: Slot? = null
) = registerProp(PineProp(kProp.name, PineType.INT, kProp, PineValue.of(initialValue), slot))

fun PineObject.boolProp(
    kProp: KProperty<Boolean>,
    initialValue: Boolean = false,
    slot: Slot? = null
) = registerProp(PineProp(kProp.name, PineType.BOOL, kProp, PineValue.of(initialValue), slot))

fun PineObject.stringProp(
    kProp: KProperty<String>,
    initialValue: String = "",
    slot: Slot? = null
) = registerProp(PineProp(kProp.name, PineType.STRING, kProp, PineValue.of(initialValue), slot))

fun PineObject.doubleProp(
    kProp: KProperty<Double>,
    initialValue: Double = 0.0,
    slot: Slot? = null
) = registerProp(PineProp(kProp.name, PineType.DOUBLE, kProp, PineValue.of(initialValue), slot))

fun <T> PineObject.registerProp(prop: PineProp<T>): PineProp<T> {
    if (nameProps.containsKey(prop.getScriptName()))
        throw PineScriptException("Property of name ${prop.getScriptName()} already exists for type ${PineObject::javaClass::name}")
    nameProps[prop.getScriptName()] = prop
    return prop
}