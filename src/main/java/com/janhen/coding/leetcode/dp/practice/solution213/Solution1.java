package main.java.janhen.leetcode.dp.practice.solution213;

import java.util.Arrays;

class Solution1 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(tryRob(Arrays.copyOfRange(nums, 0, n-1)), tryRob(Arrays.copyOfRange(nums, 1, n)));     /* 子问题分割 */
    }

    private int tryRob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i ++)
            dp[i] = Math.max(dp[i-1], nums[i] + (i-2>=0 ? dp[i-2] : 0));
        return dp[n-1];
    }
}