package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution152;

class Solution {
  public int maxProduct(int[] nums) {
    int n = nums.length;
    int res = nums[0];
    int curMax = nums[0], curMin = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) { // handle max min not meet because [i] is negative
        int t = curMax;
        curMax = curMin;
        curMin = t;
      }

      // reset max min by current num
      curMax = Math.max(nums[i], curMax * nums[i]); // 子数组 ⇒ max{[i],max*[i]}, 子序列 ⇒ max{max,max*[i]}
      curMin = Math.min(nums[i], curMin * nums[i]);

      res = Math.max(curMax, res);
    }
    return res;
  }
}