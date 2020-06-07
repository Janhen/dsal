package com.janhen.coding.leetcode.dp.knapsack.solution518;

public class Solution {
    // TODO
    public int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
