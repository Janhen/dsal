package com.janhen.coding.leetcode.array.sm_binary_search.solution35;

class Solution {
  public int searchInsert(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (target == nums[mid])
        return lo;
      else if (target > nums[mid])
        lo = mid + 1;
      else
        hi = mid - 1;
    }
    return lo;
  }
}
