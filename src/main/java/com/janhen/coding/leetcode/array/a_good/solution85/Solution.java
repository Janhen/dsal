package com.janhen.coding.leetcode.array.a_good.solution85;

import java.util.Stack;

class Solution {
    /*
    time: O(n^2)
     */
  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    int n = m == 0 ? 0 : matrix[0].length;
    int max = 0;

    int[] heights = new int[n + 1];

    for (int i = 0; i < m; i++) {
      Stack<Integer> s = new Stack<Integer>();
      // push dummy value, not handle empty stack
      s.push(-1);

      for (int j = 0; j <= n; j++) {
        if (j < n && matrix[i][j] == '1')
          heights[j] += 1;
        else
          heights[j] = 0;

        while (s.peek() != -1 && heights[j] < heights[s.peek()]) {
          int height = heights[s.pop()];
          int weight = j - s.peek() - 1;
          max = Math.max(max, height * weight);
        }

        s.push(j);
      }
    }
    return max;
  }
}