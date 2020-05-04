package main.java.janhen.leetcode.a_base.solution55;

/*
 * 记录之前最大的可达处
 */
class Solution {
  public boolean canJump(int[] nums) {
    int maxReachable = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > maxReachable) return false;     // cur position not reachable
      maxReachable = Math.max(maxReachable, i + nums[i]);           // maxReachable record
    }
    return true;    // can reach [n-1]
  }
}