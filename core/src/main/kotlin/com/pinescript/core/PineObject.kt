package com.pinescript.core

import com.pinescript.core.PineValue.Companion.of
import com.pinescript.util.safeGet
import com.pinescript.util.safeSet
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Slot = () -> Unit

interface PineSignal {

    fun getPineObject() : PineObject

    fun getScriptName(): String

    //val slots: MutableSet<Slot>

    /**
     * Execute all Slots.
     */
    fun emit() = getPineObject().slots.safeGet(getScriptName()).forEach { it() }

    /**
     * Connect a Slot to a signal.<br></br>
     * Add a Slot to the ArrayList.
     * @param slot the Slot to be added
     */
    fun connect(slot: () -> Unit) = getPineObject().connect(getScriptName(), slot)

    /**
     * Disconnect a Slot from a signal.<br></br>
     * Remove a Slot from the ArrayList.
     * @param slot the Slot to be removed
     */
    fun disconnect(slot: () -> Unit) = getPineObject().disconnect(getScriptName(), slot)

    fun disconnectAll() = getPineObject().slots[getScriptName()]!!.clear()
}

class BaseSignal(private val pineObject: PineObject, val name: String) : PineSignal {
    override fun getPineObject(): PineObject = pineObject
    override fun getScriptName(): String = name
}

open class PineProp<T>(
    private val pineObject: PineObject,
    val name: String,
    val pineType: PineType,
    val kProp: KProperty<*>,
    initialValue: PineValue<T>) : PineSignal, ReadWriteProperty<PineObject, T> {

    var value: PineValue<T> = initialValue
        set(value) {
            if (field != value) {
                field = value
                emit()
            }
        }

    override fun getPineObject(): PineObject = pineObject
    override fun getScriptName(): String = name

    override fun getValue(thisRef: PineObject, property: KProperty<*>): T = value.getValue()

    override fun setValue(thisRef: PineObject, property: KProperty<*>, value: T) {
        this.value = of(value) as PineValue<T>
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

open class ChildrenListPineProp(private val pineObject: PineObject,
                                kProp: KProperty<*>) :
    PineProp<MutableList<PineObject>>(pineObject, "children", PineType.LIST, kProp, of(mutableListOf<PineObject>()) as PineValue<MutableList<PineObject>>), Iterable<PineObject> {

    var props = mutableListOf<PineObject>()

    fun add(el: PineObject) = props.add(el).apply { emit() }

    fun remove(el: PineObject) = props.remove(el).apply { emit() }

    fun get(pos: Int): PineObject {
        return props[pos]
    }

    override fun getPineObject(): PineObject = pineObject

    override fun getScriptName(): String = "children"

    override operator fun getValue(thisRef: PineObject, property: KProperty<*>): MutableList<PineObject> = value.getValue()
    override fun iterator(): Iterator<PineObject> = ListPinePropIterator()

    inner class ListPinePropIterator : Iterator<PineObject> {
        private var pos = 0
        override fun hasNext(): Boolean = pos < props.size
        override fun next(): PineObject = props[pos++]
    }
}

open class PineObject(val id: Int = -1) {

    companion object  {
        const val SIG_MOUNT = "mount"
        const val SIG_UNMOUNT = "unmount"

        private var meta: PineMetaObject? = null

        fun getMeta(): PineMetaObject {
            synchronized(this) {
                if (meta == null) {
                    val obj = PineObject(-1)
                    meta = PineMetaObject("Object") {PineObject(it)}
                }
            }
            return meta ?: throw PineScriptException("Meta object not created")
        }
    }

    // All "events" that can be fired by an object to a script
    val signals: MutableList<PineSignal> = mutableListOf()

    // All Object properties accessible to the script
    val props: MutableList<PineProp<*>> = mutableListOf()

    // Children objects
    private val childrenList: MutableList<PineObject> = mutableListOf()

    val children: ChildrenListPineProp = childrenProp(::childrenList)

    val slots: MutableMap<String, MutableSet<Slot>> = mutableMapOf()

    // All functions that can be called from script
    val callables: MutableList<PineCallable<*>> = mutableListOf()
 //       makeCallable("printHello") { println("Hello world") },
 //       makeCallable("helloText")  { "Hello world" }
  //  )



    init {
        makeSignal(SIG_MOUNT) //.connect { println("Did mount for object $this") }
        makeSignal(SIG_UNMOUNT) //.connect { println("Did unmount for object $this") }

        makeCallable("printHello") { println("Hello world") }
        makeCallable("helloText")  { "Hello world" }
    }

    fun getSignal(name: String): PineSignal? = signals[getMeta().signalIndexes[name] ?: throw PineScriptException("signal $name not found in $this")]

    fun emitMount() {
        getSignal(SIG_MOUNT)?.emit()
        children.forEach { it.emitMount() }
    }
    fun emitUnmount() {
        children.forEach { it.dispose() }
        getSignal(SIG_UNMOUNT)?.emit()
    }

    fun connect(signal: String, slot: () -> Unit) { slots.safeSet(signal, slot) }
    fun disconnect(signal: String, slot: () -> Unit) = slots.safeGet(signal).remove(slot)

    fun getProp(name: String): PineProp<*> = props[meta!!.propIndexes[name]?: throw PineScriptException("Prop name  $name not found on $this")]

    fun dispose() {
        emitUnmount()
    }

    fun makeSignal(name: String): PineSignal {
        val sig = BaseSignal(this, name)
        signals.add(sig)
        return sig
    }

    fun <T>makeCallable(name: String, lambda: () -> T): PineCallable<T> {
        val callable = PineCallable(this, name, lambda)
        callables.add(callable)
        return callable
    }
}

fun PineObject.intProp(
    kProp: KProperty<Int>,
    initialValue: Int = 0,
    slot: (() -> Unit)? = null
) = registerProp(PineProp(this, kProp.name, PineType.INT, kProp, of(initialValue)), slot)

fun PineObject.boolProp(
    kProp: KProperty<Boolean>,
    initialValue: Boolean = false,
    slot: (() -> Unit)? = null
) = registerProp(PineProp(this, kProp.name, PineType.BOOL, kProp, of(initialValue)), slot)

fun PineObject.stringProp(
    kProp: KProperty<String>,
    initialValue: String = "",
    slot: (() -> Unit)? = null
) = registerProp(PineProp(this, kProp.name, PineType.STRING, kProp, of(initialValue)), slot)

fun PineObject.doubleProp(
    kProp: KProperty<Double>,
    initialValue: Double = 0.0,
    slot: (() -> Unit)? = null
) = registerProp(PineProp(this, kProp.name, PineType.DOUBLE, kProp, of(initialValue)), slot)

private fun PineObject.childrenProp(
    kProp: KProperty<MutableList<PineObject>>,
    slot: (() -> Unit)? = null
    ): ChildrenListPineProp = registerProp(ChildrenListPineProp(this, kProp), slot) as ChildrenListPineProp

fun <T> PineObject.registerProp(prop: PineProp<T>, slot: Slot?): PineProp<T> {
    props.add(prop)
    slot?.also { this.connect(prop.getScriptName(), slot) }
    return prop
}