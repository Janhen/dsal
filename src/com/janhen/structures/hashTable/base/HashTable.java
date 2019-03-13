package com.janhen.structures.hashtable.base;

import java.util.TreeMap;

/**
 * 固定容量的哈希表
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int N;

    public HashTable(int M) {
        this.M = M;
        N = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < hashtable.length; i ++)               /* 可 lazy load */
            hashtable[i] = new TreeMap<>();
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int indexFor(int h, int length) {
        return h & (length-1);
    }

    public int size() {
        return N;
    }

    public void add(K key, V val) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.replace(key, val);               /* 模拟哈希冲突 */
        }
        else {
            map.put(key, val);
            N ++;
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
            throw new IllegalArgumentException();  // 与 add 的不同逻辑
        map.replace(key, val);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }
}
