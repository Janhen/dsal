package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution485;

class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxLen = -1, curLen = 0;
    for (int num : nums) {
      curLen = num == 1 ? curLen + 1 : 0;  // reset OR continue
      maxLen = Math.max(curLen, maxLen);
    }
    return maxLen;
  }
}