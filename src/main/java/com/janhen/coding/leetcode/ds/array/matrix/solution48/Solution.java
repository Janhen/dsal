package com.janhen.coding.leetcode.ds.array.matrix.solution48;

class Solution {
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    int up = 0, left = 0, bottom = n - 1, right = n - 1;
    // only one element not need rotate
    while (left < right)
      rotateEdge(matrix, up++, left++, bottom--, right--);
  }

  // four point to rotate
  private void rotateEdge(int[][] matrix, int up, int left, int bottom, int right) {
    // rotate times
    int time = right - left;
    for (int i = 0; i < time; i++) {
      int tmp = matrix[up][left + i];
      matrix[up][left + i] = matrix[bottom - i][left];
      matrix[bottom - i][left] = matrix[bottom][right - i];
      matrix[bottom][right - i] = matrix[up + i][right];
      matrix[up + i][right] = tmp;
    }
  }
}