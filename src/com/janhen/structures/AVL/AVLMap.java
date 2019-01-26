package com.janhen.structures.AVL;

import com.janhen.structures.setAndmap.map.Map;

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    public void add(K key, V val) {
        avlTree.add(key, val);
    }
    public boolean contains(K key) {
        return avlTree.contains(key);
    }
    public V get(K key) {
        return avlTree.get(key);
    }

    public void set(K key, V val) {
         avlTree.set(key, val);
    }
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
