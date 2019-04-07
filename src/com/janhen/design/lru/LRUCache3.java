package com.janhen.design.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap((int) Math.ceil(capacity/DEFAULT_LOAD_FACTOR) + 1, DEFAULT_LOAD_FACTOR, true){
            private static final long serialVersionUID = 223232L;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() >= capacity;
            }
        };
    }

    public synchronized int get(int key) {
        return cache.get(key);
    }

    public synchronized void put(int key, int val) {
         cache.put(key, val);
    }
}
