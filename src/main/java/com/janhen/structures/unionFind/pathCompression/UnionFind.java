package com.janhen.structures.unionFind.pathCompression;

import com.janhen.structures.unionFind.UF;

public class UnionFind implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }

    /*
    path compression
     */
    // ★★
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException();

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        // notice
        if (pRoot == qRoot)
            return;

        // ★ 依附大树
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        }
        else {
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }
    }
}
