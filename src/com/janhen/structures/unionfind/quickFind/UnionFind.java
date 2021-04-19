package com.janhen.structures.unionfind.quickFind;

import com.janhen.structures.unionfind.UF;

/*
quick find
 */
public class UnionFind implements UF {

    private final int[] id;

    public UnionFind(int size) {

        id = new int[size];
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    @Override
    public int size() {
        return id.length;
    }

    // 查找元素 P 所对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException();
        return id[p];
    }

    @Override
    // O(1)
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    // O(N)
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == qId)
                id[i] = pId;
    }
}
