package com.janhen.coding.leetcode.array.solution85;

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
      Stack<Integer> stack = new Stack<>();
      // push dummy value, not handle empty stack
      stack.push(-1);

      for (int j = 0; j <= n; j++) {
        if (j < n && matrix[i][j] == '1')
          heights[j] += 1;
        else
          heights[j] = 0;

        while (stack.peek() != -1 && heights[j] < heights[stack.peek()]) {
          int height = heights[stack.pop()];
          int weight = j - stack.peek() - 1;
          max = Math.max(max, height * weight);
        }

        stack.push(j);
      }
    }
    return max;
  }
}