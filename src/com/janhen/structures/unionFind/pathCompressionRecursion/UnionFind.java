package com.janhen.structures.unionFind.pathCompressionRecursion;

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
    Macro semantic : 找到 p 对应的根节点并返回
    一步直接完成都指向根节点
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException();

        if (p != parent[p])
            // notice : not find(p)   , need to reduce the size
            parent[p] = find(parent[p]);

        return parent[p];
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

        if (rank[pRoot] < rank[qRoot]) {
            // p -> q
            parent[pRoot] = qRoot;
        }
        else if (rank[qRoot] < rank[pRoot]) {
            // q -> p
            parent[qRoot] = pRoot;
        }
        else {
            // p -> q
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }
    }
}
