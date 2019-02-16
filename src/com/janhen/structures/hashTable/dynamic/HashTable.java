package com.janhen.structures.hashTable.dynamic;

import java.util.TreeMap;

/**
 * 界限扩容
 */
public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;

    private static final int INIT_CAPACITY = 7;

    private TreeMap<K, V>[] hashtable;
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
        this(INIT_CAPACITY);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
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
            N ++;
            if (N >= upperTol * M)       // 扩容时机: 每个桶中平均含有的节点个数查过 upperTol
                resize(2 * M);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            N --;
            if (N < lowerTol * M && M / 2 >= INIT_CAPACITY)   /* 缩减桶时机: 桶中平均节点数小于 lowerTol, 且保证最小容量 */
                resize(M / 2);
        }
        return ret;
    }

    public void set(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException();

        map.replace(key, val);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newHashTable.length; i ++)
            newHashTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i ++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));  // 自动 rehash
            }
        }
        this.hashtable = newHashTable;
    }
}
