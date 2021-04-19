package com.janhen.design.onetoonemap;

import java.util.HashMap;
import java.util.Map;

class OneToOneMap<K, V> {
    private final Map<K, V> map = new HashMap<>();

    public V get(K key) {
        return map.get(key);
    }

    public boolean put(K key, V val) {
        if (map.containsKey(key)) {
            return map.get(key).equals(val);
        } else {
            // O(n)
            if (map.containsValue(val))
                return false;
            map.put(key, val);
        }
        return true;
    }
}