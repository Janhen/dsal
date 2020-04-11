package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution59;

class Solution {
    private int sequencer;

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        sequencer = 1;
        int left = 0, up = 0, right = n - 1, down = n - 1;
        while (left <= right)
            fillEdge(matrix, left++, up++, right--, down--);
        return matrix;
    }

    // note: direction  {--, ++}
//       extreme condition
    private void fillEdge(int[][] matrix, int left, int up, int right, int down) {
        if (left == right) {
            matrix[left][up] = sequencer++;
            return;
        }
        for (int i = left; i < right; i++)
            matrix[up][i] = sequencer++;
        for (int i = up; i < down; i++)
            matrix[i][right] = sequencer++;
        for (int i = right; i > left; i--)
            matrix[down][i] = sequencer++;
        for (int i = down; i > up; i--)
            matrix[i][left] = sequencer++;
    }
}