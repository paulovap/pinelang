/*
BSD License

Copyright (c) 2018, Paulo Pinheiro
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
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

package com.flex.core

import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class PineProp<T>(val type: PineType, val kProp: KProperty<T>, initialValue: T) : ObservableProperty<T>(initialValue) {

    private val slots = CopyOnWriteArrayList<() -> Unit>()

    private val enabled = AtomicBoolean(true)

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        for(slot in slots) {
            slot()
        }
    }

    fun getValue(): T {
        return getValue(this, kProp)
    }

    fun setValue(value: T) {
        setValue(this, kProp, value)
    }

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

    fun asBool(): PineProp<Boolean> = asType(PineType.BOOL)
    fun asDouble(): PineProp<Double> = asType(PineType.DOUBLE)
    fun asInt(): PineProp<Int> = asType(PineType.INT)
    fun asString(): PineProp<String> = asType(PineType.STRING)
    fun asObject(): PineProp<Any> = asType(PineType.OBJECT)

    private fun <X>asType(newType: PineType): PineProp<X> {
        if (newType != this.type) {
            throw QMLRuntimeException("${newType.typeName} cannot be cast to ${this.type.typeName}")
        }
        return this as PineProp<X>
    }

}
