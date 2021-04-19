package com.janhen.structures.unionfind.rankOptimize;

import com.janhen.structures.unionfind.UF;

public class UnionFind implements UF {

    private final int[] parent;
    private final int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            // notice
            rank[i] = 1;
        }
    }

    @Override
    public int size() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException();

        while (p != parent[p])
            p = parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    // ★ 根据 rank? height 优化拼接方向
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        // notice
        if (pRoot == qRoot)
            return;

        if (rank[pRoot] < rank[qRoot]) {
            // p -> q
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            // q -> p
            parent[qRoot] = pRoot;
        } else {
            // p -> q
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }
}
