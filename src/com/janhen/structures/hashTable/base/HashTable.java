package com.janhen.structures.hashTable.base;

import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;  // ★ 元素必须 `implements Comparable<>`
    private int M;
    private int N;

    public HashTable(int M) {
        this.M = M;
        N = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < hashtable.length; i ++)
            hashtable[i] = new TreeMap<>();
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;  // ★★ 去除符号位取余, 确定桶位置
    }

    public int size() {
        return N;
    }

    public void add(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.replace(key, val);
        }
        else {
            map.put(key, val);
            N ++;  // ★ 组合 update 操作
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            N --;
        }
        return ret;
    }

    public void set(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException();  // ★ 与 add 的不同逻辑

        map.replace(key, val);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
