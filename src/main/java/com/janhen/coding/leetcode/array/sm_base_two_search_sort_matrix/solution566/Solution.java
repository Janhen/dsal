package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution566;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m*n != r*c) return nums;

        int[][] matrix = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                matrix[i][j] = nums[index/n][index%n];   // one dimension use col to
                index ++;
            }
        }
        return matrix;
    }
}