package com.janhen.structures.avl.ref;

import com.janhen.structures.avl.AVLTree;
import com.janhen.structures.setandmap.map.Map;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void put(K key, V val) {
        avlTree.add(key, val);
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V val) {
        avlTree.set(key, val);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    public int size() {
        return avlTree.size();
    }

    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
