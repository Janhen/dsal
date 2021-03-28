package com.janhen.coding.leetcode.algs.math.solution169;

class Solution {
  public int majorityElement(int[] nums) {
    int candidate = -1;
    int count = 0;
    for (int num : nums) {
      // reset majority and count
      if (count == 0) {
        count = 1;
        candidate = num;
        continue;
      }
      // adjust candidate count
      count = num == candidate ? ++count : --count;
    }
    return candidate;
  }
}