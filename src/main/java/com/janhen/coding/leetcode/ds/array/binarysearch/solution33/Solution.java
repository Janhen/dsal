package com.janhen.coding.leetcode.ds.array.binarysearch.solution33;

class Solution {
  // TOWHY
/*
找出旋转数组中元素最小的索引
在数组中通过带有偏移的二分查找找出指定元素的索引
 */
  public int search(int[] nums, int target) {
    int smallestIndex = findSmallestIndexInRotateArray(nums);
    return binarySearchWithOffset(nums, smallestIndex, target);
  }

  public int findSmallestIndexInRotateArray(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] < nums[hi])     // [mid] in R half,  smallest in R half
        hi = mid;
      else         // [mid] in L half, smallest in R half
        lo = mid + 1;
    }
    return lo;
  }

  private int binarySearchWithOffset(int[] nums, int offset, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo <= hi) {         // binary search with offset
      int mid = lo + (hi - lo) / 2;
      int realMid = (mid + offset) % nums.length;   // add offset
      if (nums[realMid] == target)
        return realMid;
      else if (nums[realMid] < target)
        lo = mid + 1;
      else
        hi = mid - 1;
    }
    return -1;
  }
}