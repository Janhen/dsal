package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution64;

// time:O(N^2), space:O(N^2)
class SolutionB {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i ++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i = 1; i < m; i ++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}