package com.janhen.structures.hashtable.dynamic;

import java.util.TreeMap;

/**
 * 界限扩容
 */
public class HashTable<K, V> {

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private static final int INIT_CAPACITY = 7;

    private TreeMap<K, V>[] table;
    private int M;
    private int N;

    public HashTable(int M) {
        this.M = M;
        N = 0;
        table = new TreeMap[M];
        for (int i = 0; i < table.length; i ++)
            table[i] = new TreeMap<>();
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

    public void put(K key, V val) {
        TreeMap<K, V> node = table[hash(key)];
        if (node.containsKey(key)) {             // repeated
            node.replace(key, val);
        }
        else {
            node.put(key, val);
            N ++;
            if (N >= UPPER_TOL * M)    // grow
                resize(2 * M);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> node = table[hash(key)];
        V oldVal = null;
        if (node.containsKey(key)) {
            oldVal = node.remove(key);
            N --;
            if (N < LOWER_TOL * M && M / 2 >= INIT_CAPACITY)    // narrow
                resize(M / 2);
        }
        return oldVal;
    }

    public void set(K key, V val) {
        TreeMap<K, V> map = table[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException();

        map.replace(key, val);
    }

    public boolean contains(K key) {
        return table[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return table[hash(key)].get(key);
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newTable = new TreeMap[newM];
        for (int i = 0; i < newTable.length; i ++)
            newTable[i] = new TreeMap<>();

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i ++) {
            TreeMap<K, V> map = table[i];
            for (K key : map.keySet()) {
                newTable[hash(key)].put(key, map.get(key));  // 自动 rehash
            }
        }
        this.table = newTable;
    }
}
