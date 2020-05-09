package com.janhen.coding.leetcode.a_base.solution55;

public class Solution_my {
  public boolean canJump(int[] nums) {
    if (nums.length < 2)
      return true;
    int maxReachable = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxReachable)
        return false;
      maxReachable = Math.max(maxReachable, i + nums[i]);
    }
    return true;
  }
}
