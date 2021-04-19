package com.janhen.structures.unionfind.quickUnion;

import com.janhen.structures.unionfind.UF;

public class UnionFind implements UF {

    private final int[] parent;

    public UnionFind(int size) {
        parent = new int[size];

        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    @Override
    public int size() {
        return parent.length;
    }

    private int find(int p) {
        // notice
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException();

        while (p != parent[p])
            p = parent[p];

        return p;
    }

    @Override
    // O(h)
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    // O(h)
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // only modify a point
        parent[pRoot] = qRoot;
    }
}
