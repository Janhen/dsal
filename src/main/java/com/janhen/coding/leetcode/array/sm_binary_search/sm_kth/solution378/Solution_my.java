package com.janhen.coding.leetcode.array.sm_binary_search.sm_kth.solution378;

import java.util.PriorityQueue;

class Solution_my {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i ++)
            pq.offer(new Tuple(0, i, matrix[0][i]));

        for (int i = 0; i < k - 1; i ++) {
            Tuple t = pq.poll();
            if (t.x == m-1) continue;
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.peek().val;
    }


    class Tuple implements Comparable<Tuple> {
        int x, y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}