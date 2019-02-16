package com.janhen.structures.hashTable.resizeOptimize;

import java.util.TreeMap;

/**
 * 指定容量表控制扩容的容量
 */
public class HashTable<K, V> {

    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289,
            24593, 49157, 98317, 196613, 393241, 786433, 1572869,
            3145739, 6291469, 12582917, 25165843, 50331653,
            100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10;
    private static final int lowerTol = 2;

    private static int capacityIndex = 0;

    private TreeMap<K, V>[] hashtable;
    private int M;
    private int N;

    public HashTable() {
        this.M = capacity[capacityIndex];
        N = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < hashtable.length; i ++)
            hashtable[i] = new TreeMap<>();
    }

    private int hash(K key) {
//        int h;
//        return key == null ? 0 : (((h = key.hashCode()) ^ (h >>> 16)) & 0x7fffffff) % M;
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

            if (N >= upperTol * M && capacityIndex + 1 < capacity.length) {   // 扩容时机: 桶平均链表长度超过阈值, 且定义的容量控制表在范围内
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            N --;
            if (N < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
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
        for (int i = 0; i < oldM; i ++)
            for (K key: hashtable[i].keySet())
                newHashTable[hash(key)].put(key, hashtable[i].get(key));   // rehash

        this.hashtable = newHashTable;
    }
}
