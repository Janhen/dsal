package com.janhen.coding.leetcode.algs.dp.rob.solution213;

class Solution {
    // 因环产生两个子问题:  抢劫 [0,n-2] 处的房子,  抢劫 [1, n-1] 处的房子
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(tryRob(nums, 0, n - 2),
          tryRob(nums, 1, n - 1));     /* 子问题分割 */
    }

    private int tryRob(int[] nums, int first, int last) {
        int[] dp = new int[last + 1];
        dp[first] = nums[first];
        for (int i = first+1; i <= last; i ++) {                // relay on [i-1],[i-2]
            dp[i] = Math.max(dp[i-1], nums[i] + (i-2>=first ? dp[i-2] : 0));
        }
        return dp[last];
    }
}