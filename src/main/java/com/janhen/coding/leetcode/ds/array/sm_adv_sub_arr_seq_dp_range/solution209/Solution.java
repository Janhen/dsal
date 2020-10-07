package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution209;

public class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int sum = 0;
    int res = Integer.MAX_VALUE;
    int L = 0, R = 0;   // [L...R] 为滑动窗口
    while (R < nums.length) {
      sum += nums[R++];
      // Narrow window
      while (sum >= s) {
        res = Math.min(res, R - L);
        sum -= nums[L++];
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
