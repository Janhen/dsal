package com.janhen.coding.leetcode.algs.math.solution628;

import java.util.Arrays;

class Solution2 {
  // time: O(nlogn)
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    //One of the Three Numbers is the maximum value in the array.
    int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    int b = nums[0] * nums[1] * nums[nums.length - 1];
    return a > b ? a : b;
  }
}