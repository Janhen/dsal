package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution73;

class Solution {
  public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    // row or col need to modify 0, as clone original data
    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = true;
          cols[j] = true;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rows[i] || cols[j]) {
          // narrow space
          matrix[i][j] = 0;
        }
      }
    }
  }
}
