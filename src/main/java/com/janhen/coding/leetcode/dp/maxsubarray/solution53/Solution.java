package com.janhen.coding.leetcode.dp.maxsubarray.solution53;

import java.util.Arrays;

class Solution {
  /*
  nums[0..i] 中的「最大的子数组和」为 dp[i]

  dp[i] 有两种「选择」
    要么与前面的相邻子数组连接，形成一个和更大的子数组；
    要么不与前面的子数组连接，自成一派，自己作为一个子数组
   */
  int maxSubArray(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;

    int[] dp = new int[n];
    // base case
    dp[0] = nums[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
