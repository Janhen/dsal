package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution198;

// 可以优化一下
//
//dp[i]代表只偷到第i家的maximum amount of money
//
//状态转移方程:
//
//dp[i] = max(dp[i-1], dp[i-2] + nums[i])
// dp[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
public class SolutionDp {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];     // include itself
        for (int i = 1; i < n; i ++)
            dp[i] = Math.max(dp[i-1], nums[i] + (i >= 2 ? dp[i - 2] : 0));            // [i] self problem
        return dp[n-1];
    }
}
