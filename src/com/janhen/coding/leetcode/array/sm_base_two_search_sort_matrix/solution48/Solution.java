package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution48;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int up = 0, left = 0, bottom = n -1, right = n - 1;
        while (left < right)     // only one element not need rotate
            rotateEdge(matrix, up ++, left ++, bottom --, right --);
    }

    // four point to rotate
    private void rotateEdge(int[][] matrix, int up, int left, int bottom, int right) {
        int time = right - left;                 // rotate times
        for (int i = 0; i < time; i ++) {
            int t = matrix[up][left+i];
            matrix[up][left+i] = matrix[bottom-i][left];
            matrix[bottom-i][left] = matrix[bottom][right - i];
            matrix[bottom][right - i] = matrix[up+i][right];
            matrix[up+i][right] = t;
        }
    }
}