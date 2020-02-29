package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution64;

// time:O(N^2), space:O(1)
class Solution_reuse {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < n; i ++)
            grid[0][i] = grid[0][i-1] + grid[0][i];
        for (int i = 1; i < m; i ++)
            grid[i][0] = grid[i-1][0] + grid[i][0];
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}