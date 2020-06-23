package com.janhen.coding.leetcode.ds.hashtable.practice.solution16;

import java.util.Arrays;

public class Solution {

  // time: O(n^2)
  // 17 ms, faster than 38.83%
  public int threeSumClosest(int[] nums, int target) {
    // check
    int res = nums[0] + nums[1] + nums[nums.length - 1]; // initialization
    // ordered can two point to ++ --
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) { // note: not N, is N-2
      int L = i + 1, R = nums.length - 1;
      // L and R not equals
      while (L < R) {
        // condition to adjust L,R
        int sum = nums[i] + nums[L] + nums[R];  // init
        if (sum > target)
          R--;
        else
          L++;

        if (Math.abs(sum - target) < Math.abs(res - target)) // compare{cur diff, min diff}
          res = sum;
      }
    }
    return res;
  }
}
