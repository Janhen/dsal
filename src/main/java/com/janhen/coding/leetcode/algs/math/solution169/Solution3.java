package com.janhen.coding.leetcode.algs.math.solution169;

import java.util.Arrays;

class Solution3 {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}