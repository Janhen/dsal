package com.janhen.coding.leetcode.array.binarysearch.solution378;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    Queue<Tuple> pq = new PriorityQueue<>();
    int m = matrix.length, n = matrix[0].length;
    // put first row elements
    for (int i = 0; i < n; i++)
      pq.offer(new Tuple(0, i, matrix[0][i]));

    // not need to put all element,    total pq size = count(first row) + k - 1
    for (int i = 0; i < k - 1; i++) {
      Tuple t = pq.poll();
      // iterate to bottom row
      if (t.x == m - 1) continue;
      // iterate to next col elements(order to put), from top to bottom
      pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
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
      // prevent overflow
      return Integer.compare(this.val, that.val);
    }
  }
}