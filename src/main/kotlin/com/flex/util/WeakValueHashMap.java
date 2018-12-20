package com.flex.util;
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

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


/**
 * A Map that holds weak reference to values that will be cleaned automatically.
 * @param <K> Key Type
 * @param <V> Value Type
 */
public class WeakValueHashMap<K,V> extends AbstractMap<K,V> {

    private HashMap<K, WeakValue<V>> references;
    private ReferenceQueue<V> gcQueue;


    public WeakValueHashMap(int capacity) {
        references = new HashMap<>(capacity);
        gcQueue = new ReferenceQueue<V>();
    }

    public WeakValueHashMap() {
        this(1);
    }


    @Override
    public V put(K key, V value) {
        processQueue();
        WeakValue<V> valueRef = new WeakValue<>(key, value, gcQueue);
        return getReferenceValue(references.put(key, valueRef));
    };

    @Override
    public V get(Object key) {
        processQueue();
        return getReferenceValue(references.get(key));
    }

    @Override
    public V remove(Object key) {
        return getReferenceValue(references.get(key));
    }

    @Override
    public void clear() {
        references.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        processQueue();
        return references.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        processQueue();
        for (Map.Entry<K, WeakValue<V>> entry : references.entrySet()) {
            if (value == getReferenceValue(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<K> keySet() {
        processQueue();
        return references.keySet();
    }

    @Override
    public int size() {
        processQueue();
        return references.size();
    }

    @Override
    public Set<Map.Entry<K,V>> entrySet() {
        processQueue();

        Set<Map.Entry<K,V>> entries = new LinkedHashSet<Map.Entry<K,V>>();
        for (Map.Entry<K,WeakValue<V>> entry : references.entrySet()) {
            entries.add(new AbstractMap.SimpleEntry<K,V>(entry.getKey(), getReferenceValue(entry.getValue())));
        }
        return entries;
    }

    public Collection<V> values() {
        processQueue();

        Collection<V> values = new ArrayList<V>();
        for (WeakValue<V> valueRef : references.values()) {
            values.add(getReferenceValue(valueRef));
        }
        return values;
    }

    private V getReferenceValue(WeakValue<V> valueRef) {
        return valueRef == null ? null : valueRef.get();
    }

    // remove entries once their value is scheduled for removal by the garbage collector
    @SuppressWarnings("unchecked")
    private void processQueue() {
        WeakValue<V> valueRef;
        while ( (valueRef = (WeakValue<V>) gcQueue.poll()) != null ) {
            references.remove(valueRef.getKey());
        }
    }

    // for faster removal in {@link #processQueue()} we need to keep track of the key for a value
    private class WeakValue<T> extends WeakReference<T> {
        private final K key;

        private WeakValue(K key, T value, ReferenceQueue<T> queue) {
            super(value, queue);
            this.key = key;
        }

        private K getKey() {
            return key;
        }
    }

}
