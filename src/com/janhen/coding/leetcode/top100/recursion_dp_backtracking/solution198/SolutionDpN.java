package com.janhen.leetcode.top100.recursion_dp_backtracking.solution198;

// > 思路 1
//******- 时间复杂度: O(N)******- 空间复杂度: O(N)******
//
//- dp[i][0]代表偷到第i家，并且不偷第i家的最大收益
//- dp[i][1]代表偷到第i家，并且偷第i家的最大收益
public class SolutionDpN {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        // dp[i] 表示考虑抢劫 nums[0...i] 所能获得的最大收益
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ; i ++)
            dp[i] = Math.max(dp[i - 1], nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0));
        return dp[n-1];
    }
}
