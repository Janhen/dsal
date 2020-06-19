package com.janhen.coding.leetcode.math.solution462;

import java.util.Arrays;

public class Solution {
  // time: O(NlogN)
  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int move = 0;
    int l = 0, h = nums.length - 1;
    while (l <= h) {
      move += nums[h] - nums[l];
      l++;
      h--;
    }
    return move;
  }
}
