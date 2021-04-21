package com.janhen.structures.design.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 借助 JDK 中的 LinkedHashMap 扩展实现
 */
public class LRUCache3 {
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap((int) Math.ceil(capacity / DEFAULT_LOAD_FACTOR) + 1,
          DEFAULT_LOAD_FACTOR, true) {
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
