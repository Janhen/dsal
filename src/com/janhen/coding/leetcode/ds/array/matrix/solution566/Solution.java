package com.janhen.coding.leetcode.ds.array.matrix.solution566;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c)
            return nums;

        int[][] matrix = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // one dimension use col to
                matrix[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return matrix;
    }
}