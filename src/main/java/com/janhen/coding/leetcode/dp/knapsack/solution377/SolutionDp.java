package com.janhen.coding.leetcode.dp.knapsack.solution377;

class SolutionDp {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i ++) {
            for (int j = 0; j < nums.length; j ++) {
                dp[i] = dp[i] + (i >= nums[j] ? dp[i-nums[j]] : 0);
            }
        }
        return dp[target];
    }
}