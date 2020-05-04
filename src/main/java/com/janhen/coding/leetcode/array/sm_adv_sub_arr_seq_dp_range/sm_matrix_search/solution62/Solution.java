package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution62;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);    // INIT

        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}