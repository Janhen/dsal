package com.janhen.coding.leetcode.algs.dp.stringedit.solution650;

public class Solution2 {
  // TODO
  public int minSteps(int n) {
    int[] dp = new int[n + 1];
    int h = (int) Math.sqrt(n);
    for (int i = 2; i <= n; i++) {
      dp[i] = i;
      for (int j = 2; j <= h; j++) {
        if (i % j == 0) {
          dp[i] = dp[j] + dp[i / j];
          break;
        }
      }
    }
    return dp[n];
  }
}
