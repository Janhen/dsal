package com.janhen.coding.leetcode.search.practice.solution16;

import java.util.Arrays;

public class Solution {

  // time: O(n^2)
  // 17 ms, faster than 38.83%
  public int threeSumClosest(int[] nums, int target) {
    // check
    int res = nums[0] + nums[1] + nums[nums.length - 1]; // initialization
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) { // note: not N, is N-2
      int p = i + 1, q = nums.length - 1;
      while (p < q) {
        int sum = nums[i] + nums[p] + nums[q];  // init
        if (sum > target)
          q--;
        else
          p++;
        if (Math.abs(sum - target) < Math.abs(res - target)) // compare{cur diff, min diff}
          res = sum;
      }
    }
    return res;
  }
}
