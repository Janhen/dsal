package com.janhen.coding.leetcode.algs.dp.stocktrading.solution188;

public class Solution {
  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    if (k > n / 2)
      return maxProfit_k_inf(prices);

    int[][][] dp = new int[n][k + 1][2];
    for (int i = 0; i < n; i++)
      for (int j = k; j >= 1; j--) {
        if (i - 1 == -1) { /* 处理 base case */ }
        dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
      }
    return dp[n - 1][k][0];
  }

  private int maxProfit_k_inf(int[] prices) {
    int n = prices.length;
    int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int temp = dp_i_0;
      dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
      dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
    }
    return dp_i_0;
  }
}
