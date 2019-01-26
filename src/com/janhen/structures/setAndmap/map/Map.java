package com.janhen.structures.setAndmap.map;

public interface Map<K, V> {
    void add(K key, V val);
    V get(K key);
    boolean contains(K key);

    V remove(K key);
    void set(K key, V val);

    int size();
    boolean isEmpty();
}
