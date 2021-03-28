package com.janhen.coding.leetcode.ds.array.matrix.solution59;

class Solution {
  private int sequencer;

  public int[][] generateMatrix(int n) {
    // init space
    int[][] matrix = new int[n][n];
    // fill number to position
    sequencer = 1;
    int left = 0, up = 0, right = n - 1, down = n - 1;
    while (left <= right)
      fillEdge(matrix, left++, up++, right--, down--);
    return matrix;
  }

  // note: direction  {--, ++}
  private void fillEdge(int[][] matrix, int left, int up, int right, int down) {
    if (left == right) {
      matrix[left][up] = sequencer++;
      return;
    }
    //  →
    for (int i = left; i < right; i++)
      matrix[up][i] = sequencer++;
    //   ↓
    for (int i = up; i < down; i++)
      matrix[i][right] = sequencer++;
    //  ←
    for (int i = right; i > left; i--)
      matrix[down][i] = sequencer++;
    // ↑
    for (int i = down; i > up; i--)
      matrix[i][left] = sequencer++;
  }
}