package com.janhen.coding.leetcode.graphdfsbfs.dfs.solution547;

import java.util.TreeSet;

class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0] == null || M[0].length == 0)
            return 0;

        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (M[i][j] == 1)
                    uf.unionElements(i, j);
            }
        }
        return uf.totalGroup();
    }

    public interface UF {
        int size();
        int totalGroup();
        void unionElements(int p, int q);
        boolean isConnected(int p, int q);
    }

    public class UnionFind implements UF {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < parent.length; i ++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        @Override
        public int size() {
            return parent.length;
        }

        @Override
        public int totalGroup() {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < parent.length; i ++)
                set.add(find(i));
            return set.size();
        }

        @Override
        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        private int find(int p) {
            // c

            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        @Override
        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                if (rank[pRoot] < rank[qRoot])
                    parent[pRoot] = qRoot;
                else if (rank[pRoot] > rank[qRoot])
                    parent[qRoot] = pRoot;
                else {
                    parent[pRoot] = qRoot;
                    rank[qRoot] ++;
                }
            }
        }
    }
}