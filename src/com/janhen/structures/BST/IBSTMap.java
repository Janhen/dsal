package com.janhen.structures.BST;

public interface IBSTMap<K extends Comparable<K>, V> {

    int size();
    boolean isEmpty();

    void add(K key, V val);

    V get(K key);
    boolean contains(K key);

    void set(K key, V val);

    V removeMax();
    V removeMin();
    V remove(K key);

    V maximum();
    V minimum();
}
