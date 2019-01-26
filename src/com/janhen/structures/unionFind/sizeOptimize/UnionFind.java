package com.janhen.structures.unionFind.sizeOptimize;

import com.janhen.structures.unionFind.UF;

public class UnionFind implements UF {

    private int[] parent;
    private int[] sz;

    public UnionFind(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i ++) {
            parent[i] = i;
            sz[i] = 1;
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
    // ★ 根据 size 优化拼接方向
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (sz[pRoot] <= sz[qRoot]) {
            // p -> q
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else  { // pSize > qSize
            // q -> p
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
