package com.janhen.leetcode.top100.recursion_dp_backtracking.dfs.solution547;

//547. Friend Circles
//        https://leetcode.com/problems/friend-circles/description/
// medium
// DFS, UF

// There are N students in a class. Some of them are friends, while some are not.
// Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
//
//Given a N*N matrix M representing the friend relationship between students in the class.
// If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
// And you have to output the total number of friend circles among all the students.
//
//Example 1:
//Input:
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//Output: 2
//Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
//The 2nd student himself is in a friend circle. So return 2.
//Example 2:
//Input:
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//Output: 1
//Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
//so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so ret

// 朋友是相互的 [i][j] 是朋友 [j][i] 是朋友

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