package com.janhen.coding.leetcode.dp.rob.solution213;

class Solution2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(tryRob(nums, 0, n-2), tryRob(nums, 1, n-1));
    }

    // dp[i] = max(dp[i-1], dp[i-2]+nums[i])
    //            不抢[i]         抢[i]
    private int tryRob(int[] nums, int L, int R) {
        int pre2 = 0, pre1 = 0;
        for (int i = L; i <= R; i ++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}