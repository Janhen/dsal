package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution73;

class Solution$ {
  // 遍历过程中修改将要遍历元素的值
  // 类似集合中新建...
  // space: O(MN)
  public void setZeroes(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    boolean[][] record = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          for (int p = 0; p < m; p++)   // row, col need to modify 0
            record[p][j] = true;
          for (int q = 0; q < n; q++)
            record[i][q] = true;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (record[i][j])
          matrix[i][j] = 0;
      }
    }
  }
}
