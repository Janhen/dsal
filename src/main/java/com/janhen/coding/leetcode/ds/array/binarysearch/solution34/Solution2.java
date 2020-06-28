package com.janhen.coding.leetcode.ds.array.binarysearch.solution34;

class Solution2 {

  // 复用同一个函数
  public int[] searchRange(int[] nums, int target) {
    int first = binarySearch(nums, target);
    int last = binarySearch(nums, target + 1) - 1;
    if (first == nums.length || nums[first] != target) {
      return new int[]{-1, -1};
    } else {
      return new int[]{first, Math.max(first, last)};
    }
  }

  // TOWHY
  private int binarySearch(int[] nums, int target) {
    // 注意 h 的初始值
    int lo = 0, hi = nums.length;
    while (lo < hi) {
      int m = lo + (hi - lo) / 2;
      if (nums[m] >= target) {
        hi = m;
      } else {
        lo = m + 1;
      }
    }
    return lo;
  }
}