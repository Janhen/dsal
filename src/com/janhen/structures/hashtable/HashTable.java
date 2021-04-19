package com.janhen.structures.hashtable;

import java.util.TreeMap;

/**
 * 哈希表<br>
 * <p>
 * Hash 函数<br>
 * 简单的取模<br>
 * <p>
 * <p>
 * 扩容<br>
 * 何时扩容? 何时缩容?<br>
 * 平均每个桶上存放数据的个数决定<br>
 * <p>
 * 如何扩容? 每次扩容多少?<br>
 * 通过扩展数组实现<br>
 * 根据当前的数据规模，参考经验性的扩容大小控制每次扩容<br>
 * Prime number control size http://planetmath.org/goodhashtableprimes
 */
public class HashTable<K, V> {
    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private static int capIdx = 0;

    private final int[] capacity = {
      53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241, 786433,
      1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189,
      805306457, 1610612741};

    private TreeMap<K, V>[] table;
    /* array size */
    private int M;
    // real storage count
    private int N;

    public HashTable() {
        this.M = capacity[capIdx];
        N = 0;
        table = new TreeMap[M];
        for (int i = 0; i < table.length; i++)
            table[i] = new TreeMap<>();
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void put(K key, V val) {
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            map.replace(key, val);
        } else {
            map.put(key, val);
            N++;
            if (N >= UPPER_TOL * M && capIdx + 1 < capacity.length) { /* 扩容时机: 桶平均链表长度超过阈值, 且定义的容量控制表在范围内 */
                capIdx++;
                resize(capacity[capIdx]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> node = table[hash(key)];
        V deleteVal = null;
        if (node.containsKey(key)) {
            deleteVal = node.remove(key);
            N--;
            if (N < LOWER_TOL * M && capIdx - 1 >= 0) {
                capIdx++;
                resize(capacity[capIdx]);
            }
        }
        return deleteVal;
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
        for (int i = 0; i < newTable.length; i++)
            newTable[i] = new TreeMap<>();
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++)
            for (K key : table[i].keySet())
                newTable[hash(key)].put(key, table[i].get(key)); // rehash
        this.table = newTable;
    }
}
