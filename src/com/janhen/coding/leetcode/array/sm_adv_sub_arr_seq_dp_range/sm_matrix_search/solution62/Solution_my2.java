package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution62;

import java.util.Arrays;

public class Solution_my2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
