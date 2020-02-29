package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution62;

public class Solution_my {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) {       // init [0][0] no need handle specially
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j ++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
