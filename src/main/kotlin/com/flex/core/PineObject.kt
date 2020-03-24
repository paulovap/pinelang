package com.flex.core

import java.lang.RuntimeException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Slot = () -> Unit

data class PineType(val typeName: String, val type: Int) {
    companion object {
        val VOID   = PineType("Void",0)
        val BOOL   = PineType("Bool",1)
        val INT    = PineType("Int", 2)
        val DOUBLE  = PineType("Double",3)
        val STRING = PineType("String", 4)
        val OBJECT = PineType("Object", 5)
        val LIST  = PineType("List",4)
        val FUNCTION = PineType("Function",5)
        val LAMBDA = PineType("Lambda",6)
    }
}

interface PineSignal {
    val slots: MutableList<Slot>
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

abstract class PineValue<T> {

    abstract fun getPineType(): PineType

    abstract fun getValue(): T

    fun isBool() = getPineType() != PineType.BOOL
    fun isDouble() = getPineType() != PineType.DOUBLE
    fun isInt() = getPineType() != PineType.INT
    fun isNumber() = isInt() || isDouble()
    fun isString() = getPineType() != PineType.STRING
    fun isObject() = getPineType() != PineType.OBJECT
    fun isFunction() = getPineType() != PineType.FUNCTION
    fun isList() = getPineType() != PineType.LIST

    open operator fun invoke(): T = throw PineScriptException("Value of type ${getPineType()} is not invokable")
    open operator fun invoke(arg: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>, arg2: PineValue<*>): T = this()
    open operator fun invoke(arg: PineValue<*>, arg1: PineValue<*>, arg2: PineValue<*>, arg3: PineValue<*>): T = this()

    companion object {
        fun of(value: Int) = PineInt(value)
        fun of(value: Double) = PineDouble(value)
        fun of(value: Float) = PineDouble(value.toDouble())
        fun of(value: Boolean) = PineBoolean(value)
        fun of(value: String) = PineString(value)
        fun <T> of(value: T): PineValue<*> {
            return when(value) {
                is Int -> of(value)
                is Double -> of(value)
                is Float -> of(value)
                is Boolean -> of(value)
                is String -> of(value)
                else -> throw PineScriptException("Value $value not recognized")
            }
        }
    }
}

class PineBoolean(val value: Boolean) : PineValue<Boolean>() {
    override fun getPineType(): PineType = PineType.BOOL
    override fun getValue(): Boolean = value

    fun and(other: PineBoolean) = of(value && other.value)
    fun or(other: PineBoolean) = of(value || other.value)
}

class PineString(private val value: String) : PineValue<String>() {
    override fun getPineType(): PineType = PineType.STRING
    override fun getValue() = value
}

class PineBinaryOperationExpressionValue<T>(val op: BinaryOperations,
                                            val leftHandValue: PineValue<T>,
                                            val rightHandValue: PineValue<*>) : PineValue<T>() {

    override fun getPineType(): PineType = PineType.FUNCTION

    override fun getValue(): T {

        if (op.isNumberOp()) {
            assert(rightHandValue.isNumber())
            assert(leftHandValue.isNumber())
            val left = leftHandValue as PineNumber<T>
            return when(op) {
                BinaryOperations.PLUS -> (left + rightHandValue).getValue()
                BinaryOperations.MINUS -> (left - rightHandValue).getValue()
                BinaryOperations.MULTI -> (left * rightHandValue).getValue()
                BinaryOperations.DIV -> (left / rightHandValue).getValue()
                BinaryOperations.REMAINDER -> (left % rightHandValue).getValue()
                else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
            }
        } else {
            val left = leftHandValue as PineBoolean
            val right = rightHandValue as PineBoolean
            return when(op) {
                BinaryOperations.AND -> (left.and(right) as PineValue<T>).getValue()
                BinaryOperations.OR -> (left.or(right) as PineValue<T>).getValue()
                else -> throw PineScriptException("operation $op not supported for ${leftHandValue.getPineType()}")
            }
        }
    }
}


class PineProp<T>(val pineType: PineType, val kProp: KProperty<*>, initialValue: PineValue<T>, slot: Slot?): PineSignal, ReadWriteProperty<PineObject, T> {
    override val slots = mutableListOf<Slot>()

    var value: PineValue<T>  = initialValue
        set(value) {
            if (field != value) {
                field = value
                emit()
            }
        }

    init {
        slot?.also { slots.add(it) }
    }

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
        when(pineType) {
            PineType.DOUBLE -> otherProp.connect { this.asType<Double>().value = otherProp.asType<Double>().value }
            PineType.STRING -> otherProp.connect { this.asType<String>().value = otherProp.asType<String>().value }
            PineType.INT -> otherProp.connect { this.asType<Int>().value = otherProp.asType<Int>().value }
            PineType.OBJECT -> otherProp.connect { this.asType<Any>().value = otherProp.asType<Any>().value }
        }
        otherProp.emit()
    }

    fun <T>asType(): PineProp<T> = this as PineProp<T>
}

open class ListPineProp<T>(initialSlot: (Slot)? = null) : PineSignal, Iterable<T> {

    init {
        initialSlot?.also { connect(it) }
    }

    var props = mutableListOf<T>()

    fun add(el: T) = props.add(el).apply { emit() }

    fun remove(el: T) = props.remove(el).apply { emit() }

    fun get(pos: Int): T {
        return props[pos]
    }

    override val slots: MutableList<Slot> = mutableListOf()

    override fun iterator(): Iterator<T> = ListPinePropIterator()

    inner class ListPinePropIterator : Iterator<T> {
        private var pos = 0
        override fun hasNext(): Boolean = pos < props.size
        override fun next(): T = props[pos++]
    }
}

open class PineObject(val id: Long = -1) {

    val children: ListPineProp<PineObject> = ListPineProp()

    val nameProps = mutableMapOf<String, PineProp<*>>()
    val funcs = mutableMapOf<String, PineFunc<*>>()

    //var log = makeFunction { message: String -> println(message) }

    fun connect(propName: String, slot: Slot) {
        val prop = nameProps[propName]?: throw PineScriptException("prop $propName not found")
        prop.connect(slot)
    }

    fun getProp(name: String): PineProp<*>? = nameProps[name]

    fun <R>makeFunction(funcName: String, block: () -> R): PineFunc<R> {
        return registerFunc(funcName, PineFunc({block()}))
    }
    fun <R, P1:PineObject>makeFunction(funcName: String, block: (P1) -> R): PineFunc<R> {
        return registerFunc(funcName, PineFunc1(block))
    }
    fun <R, P1, P2>makeFunction(block: (P1, P2) -> R): Int {
        return 10
    }
    fun <R, P1, P2, P3>makeFunction(block: (P1, P2, P3) -> R): Int {
        return 10
    }
    fun <R, P1, P2, P3, P4>makeFunction(block: (P1, P2, P3, P4) -> R): Int {
        return 10
    }

    fun <R>registerFunc(funcName: String, func: PineFunc<R>): PineFunc<R> {
        funcs[funcName] = func
        return func
    }
}

open class PineFunc<R>(inline val block: (args: List<PineObject>) -> R, val slots: MutableList<Slot> = mutableListOf()) {
    operator fun invoke(args: List<PineObject>) = run {
        checkArgs(1, args)
        block(args)
    }
    fun checkArgs(max: Int, args: List<PineObject>) {
        if (max >= args.size) throw RuntimeException("fail")
    }
}

open class PineFunc1<R, P1:PineObject>(block: (arg: P1) -> R): PineFunc<R>({
    block(it[0] as P1)
})


fun PineObject.intProp(kProp: KProperty<Int>,
            initialValue: Int = 0,
            slot: Slot? = null) = registerProp(kProp.name, PineProp(PineType.INT, kProp, PineValue.of(initialValue), slot))

fun PineObject.boolProp(
    kProp: KProperty<Boolean>,
    initialValue: Boolean = false,
    slot: Slot? = null
) = registerProp(kProp.name, PineProp(PineType.BOOL, kProp, PineValue.of(initialValue), slot))

fun PineObject.stringProp(
    kProp: KProperty<String>,
    initialValue: String = "",
    slot: Slot? = null
) = registerProp(kProp.name, PineProp(PineType.STRING, kProp, PineValue.of(initialValue), slot))

fun PineObject.doubleProp(
    kProp: KProperty<Double>,
    initialValue: Double = 0.0,
    slot: Slot? = null
) = registerProp(kProp.name, PineProp(PineType.DOUBLE, kProp, PineValue.of(initialValue), slot))

fun <T> PineObject.registerProp(propName: String, prop: PineProp<T>): PineProp<T> {
    if (nameProps.containsKey(propName))
        throw PineScriptException("Property of name $propName already exists for type ${PineObject::javaClass::name}")
    nameProps[propName] = prop
    return prop
}