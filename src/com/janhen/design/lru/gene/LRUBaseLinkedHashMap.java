package com.janhen.design.lru.gene;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUBaseLinkedHashMap<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private LinkedHashMap<K,V> cache;

    public LRUBaseLinkedHashMap(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap((int) Math.ceil(capacity/DEFAULT_LOAD_FACTOR) + 1, DEFAULT_LOAD_FACTOR, true){
            private static final long serialVersionUID = 223232L;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() >= capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized V put(K key, V val) {
        return cache.put(key, val);
    }

    public synchronized V remove(K key) {
        return cache.remove(key);
    }

    public synchronized boolean exist(K key) {
        return cache.containsKey(key);
    }

    public synchronized void clear() {
        cache.clear();
    }

    public synchronized int size() {
        return cache.size();
    }

    public synchronized Set<Map.Entry<K,V>> getAll() {
        return cache.entrySet();
    }

}
