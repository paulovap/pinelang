/*
BSD License

Copyright (c) 2020, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Paulo Pinheiro nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.pinelang.core

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias Slot = () -> Unit

data class PineConnection(val signalIdx: Int, val slot: Slot)

interface PineSignal {

  fun getPineObject(): PineObject

  fun getScriptName(): String

  /** Execute all Slots. */
  fun emit() = getPineObject().emit(getScriptName())

  /**
   * Connect a Slot to a signal.<br></br> Add a Slot to the ArrayList.
   * @param slot the Slot to be added
   */
  fun connect(slot: () -> Unit) = getPineObject().connect(getScriptName(), slot)

  /**
   * Disconnect a Slot from a signal.<br></br> Remove a Slot from the ArrayList.
   * @param slot the Slot to be removed
   */
  fun disconnect(slot: () -> Unit) = getPineObject().disconnect(getScriptName(), slot)
}

class BaseSignal(private val pineObject: PineObject, val name: String) : PineSignal {
  override fun getPineObject(): PineObject = pineObject
  override fun getScriptName(): String = name
}

@Suppress("UNCHECKED_CAST")
open class PineProp<T>(
    private val pineObject: PineObject,
    val name: String,
    val kProp: KProperty<*>,
    val expr: PineExpr<Any?>
) : PineSignal, ReadWriteProperty<PineObject, T> {

  override fun getPineObject(): PineObject = pineObject
  override fun getScriptName(): String = name

  override fun getValue(thisRef: PineObject, property: KProperty<*>): T = expr() as T

  override fun setValue(thisRef: PineObject, property: KProperty<*>, value: T) {
    expr.update { value }
    emit()
  }

  fun <T> bind(other: PineProp<T>) {
    this.expr.update(other.expr) { other.expr() }
  }

  private fun checkType(other: PineProp<*>): PineProp<*> {
    if (other.expr.pineType != expr.pineType)
        throw PineScriptException("unable to bind prop $other into $this. Incompatible types}")
    return this
  }

  fun <T> asType(): PineProp<T> = this as PineProp<T>

  override fun toString() = "${pineObject.name}::${name} = ${expr()}"
}

@Suppress("UNCHECKED_CAST")
open class ChildrenListPineProp(private val pineObject: PineObject, kProp: KProperty<*>) :
    PineProp<MutableList<PineObject>>(
        pineObject,
        "children",
        kProp,
        PineExpr(pineType = PineType.LIST, calculation = { mutableListOf<PineObject>() })),
    Iterable<PineObject> {

  init {
    expr.update { props }
  }
  var props = mutableListOf<PineObject>()

  fun add(el: PineObject) = props.add(el).apply { emit() }

  fun remove(el: PineObject) = props.remove(el).apply { emit() }

  fun get(pos: Int): PineObject {
    return props[pos]
  }

  override fun getPineObject(): PineObject = pineObject

  override fun getScriptName(): String = "children"

  override operator fun getValue(
      thisRef: PineObject, property: KProperty<*>
  ): MutableList<PineObject> = expr() as MutableList<PineObject>

  override fun iterator(): Iterator<PineObject> = ListPinePropIterator()

  inner class ListPinePropIterator : Iterator<PineObject> {
    private var pos = 0
    override fun hasNext(): Boolean = pos < props.size
    override fun next(): PineObject = props[pos++]
  }
}

abstract class PineObject(val id: Int = -1, var name: String? = null) {

  companion object {
    const val SIG_MOUNT = "mount"
    const val SIG_UNMOUNT = "unmount"
    const val INVALID_ID = Int.MIN_VALUE
  }

  // All "events" that can be fired by an object to a script
  val signals: MutableList<PineSignal> = mutableListOf()

  // All Object properties accessible to the script
  val props: MutableList<PineProp<*>> = mutableListOf()

  // Children objects
  private val childrenList: MutableList<PineObject> = mutableListOf()

  val children: ChildrenListPineProp = childrenProp(::childrenList)

  val slots: MutableList<PineConnection> = mutableListOf()

  // All functions that can be called from script
  val callables: MutableList<PineCallable<*>> = mutableListOf()
  //       makeCallable("printHello") { println("Hello world") },
  //       makeCallable("helloText")  { "Hello world" }
  //  )

  init {
    makeSignal(SIG_MOUNT) // .connect { println("Did mount for object $this") }
    makeSignal(SIG_UNMOUNT) // .connect { println("Did unmount for object $this") }

    makeCallable("printHello") { println("Hello world") }
    makeCallable("helloText") { "Hello world" }
  }

  abstract fun getMeta(): PineMetaObject

  fun emit(signal: String) {
    val sigIdx = getMeta().indexOfAny(signal)
    for (i in 0 until slots.size) {
      val connection = slots[i]
      if (connection.signalIdx == sigIdx) connection.slot()
    }
    // slots[getMeta().indexOfAny(signal)]?.forEach { it() }
  }

  fun emitMount() {
    emit(SIG_MOUNT)
    children.forEach { it.emitMount() }
  }

  fun emitUnmount() {
    children.forEach { it.dispose() }
    emit(SIG_UNMOUNT)
  }

  fun connect(signal: String, slot: () -> Unit): Boolean {
    if (id != INVALID_ID) {
      return slots.add(PineConnection(getMeta().indexOfAny(signal)!!, slot))
    }
    return false
  }

  fun disconnect(signal: String, slot: () -> Unit): Boolean =
      slots.remove(PineConnection(getMeta().indexOfAny(signal)!!, slot))

  fun getProp(name: String): PineProp<*> = props[getMeta().indexOfProp(name)!!]

  fun dispose() {
    emitUnmount()
  }

  fun makeSignal(name: String): PineSignal {
    val sig = BaseSignal(this, name)
    signals.add(sig)
    return sig
  }

  fun <T> makeCallable(name: String, lambda: () -> T): PineExpr<T> {
    val callable = PineCallable(this, name, lambda)
    callables.add(callable)
    return callable
  }

  override fun toString(): String {
    return "PineObject(name=$name, id=$id)"
  }
}

fun PineObject.intProp(kProp: KProperty<Int>, initialValue: Int = 0) =
    registerProp<Int>(PineProp(this, kProp.name, kProp, intExpr(initialValue) as PineExpr<Any?>))

fun PineObject.boolProp(kProp: KProperty<Boolean>, initialValue: Boolean = false) =
    registerProp(
        PineProp<Boolean>(this, kProp.name, kProp, boolExpr { initialValue } as PineExpr<Any?>))

fun PineObject.stringProp(kProp: KProperty<String>, initialValue: String = "") =
    registerProp(
        PineProp<String>(this, kProp.name, kProp, stringExpr { initialValue } as PineExpr<Any?>))

fun PineObject.doubleProp(kProp: KProperty<Double>, initialValue: Double = 0.0) =
    registerProp(
        PineProp<Double>(this, kProp.name, kProp, doubleExpr { initialValue } as PineExpr<Any?>))

private fun PineObject.childrenProp(
    kProp: KProperty<MutableList<PineObject>>
): ChildrenListPineProp = registerProp(ChildrenListPineProp(this, kProp)) as ChildrenListPineProp

fun <T> PineObject.registerProp(prop: PineProp<T>): PineProp<T> {
  props.add(prop)
  return prop
}
