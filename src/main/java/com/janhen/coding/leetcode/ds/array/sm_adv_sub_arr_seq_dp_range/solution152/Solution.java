package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution152;

class Solution {
  public int maxProduct(int[] nums) {
    int res = nums[0];

    // Pre-process record max, min to iterate
    int curMax = nums[0];
    int curMin = nums[0];
    // 1. Iterate to update record
    for (int i = 1; i < nums.length; i++) {
      // 2. handle max min not meet because [i] is negative
      if (nums[i] < 0) {
        int t = curMax;
        curMax = curMin;
        curMin = t;
      }
      curMax = Math.max(nums[i], curMax * nums[i]); // 子数组 ⇒ max{[i],max*[i]}, 子序列 ⇒ max{max,max*[i]}
      curMin = Math.min(nums[i], curMin * nums[i]);
      // 3. collect result
      res = Math.max(res, curMax);
    }
    return res;
  }
}