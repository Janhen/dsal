package com.janhen.coding.leetcode.algs.dp.knapsack.other;


// check??
public class Solution2 {

    public int knapsack01(int[] w, int[] v, int C) {
        int[][] dp = new int[w.length + 1][C + 1];
        for (int i = w.length - 1; i >= 0; i--) {
            for (int j = C; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + w[i] <= C) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i + 1][j + w[i]]);
                }
            }
        }
        return dp[0][0];
    }
}
