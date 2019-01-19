package com.prituladima.yaal.collections.map;

import com.prituladima.yaal.misc.Factory;

import java.util.TreeMap;

/**
 *  */
public class CPPTreeMap<K, V> extends TreeMap<K, V> {
    private final Factory<V> defaultValueFactory;

    public CPPTreeMap(Factory<V> defaultValueFactory) {
        this.defaultValueFactory = defaultValueFactory;
    }

    @Override
    public V get(Object key) {
        if (containsKey(key)) {
            return super.get(key);
        }
        V value = defaultValueFactory.create();
        try {
            //noinspection unchecked
            super.put((K) key, value);
            return value;
        } catch (ClassCastException e) {
            return value;
        }
    }
}
