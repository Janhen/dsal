package com.janhen.coding.leetcode.algs.dp.knapsack.solution416;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int C = sum / 2;
        boolean[] dp = new boolean[C + 1];
        for (int i = 0; i <= C; i ++)     // [0] put or not put in backpack
            dp[i] = nums[0] == i;
        for (int i = 1; i < nums.length; i ++) {     // from [1] to judge put or not put
            for (int j = C; j >= 0; j --) {    // [i] is or not put in
                dp[j] = dp[j] || (j >= nums[i] ? dp[j-nums[i]] : false);
            }
        }
        return dp[C];
    }
}
