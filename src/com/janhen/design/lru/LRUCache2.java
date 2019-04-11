package com.janhen.design.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap((int) Math.ceil(capacity/DEFAULT_LOAD_FACTOR) + 1, DEFAULT_LOAD_FACTOR, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int val) {
         cache.put(key, val);
    }
}
