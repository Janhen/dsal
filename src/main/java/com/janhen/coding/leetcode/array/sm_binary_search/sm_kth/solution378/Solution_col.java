package main.java.janhen.leetcode.array.sm_binary_search.sm_kth.solution378;

// 378. Kth Smallest Element in a Sorted Matrix
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

/*
Medium
966
74
Given a n x n matrix where each of the rows and columns are sorted in ascending order,
find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.*/

import java.util.PriorityQueue;

/*
 * 14 ms, faster than 62.54%
 */
class Solution_col {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i ++)    // first col
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        for (int i = 0; i < k - 1; i ++) {
            Tuple tuple = pq.poll();
            if (tuple.y == n-1) continue;
            pq.offer(new Tuple(tuple.x, tuple.y+1, matrix[tuple.x][tuple.y+1]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}