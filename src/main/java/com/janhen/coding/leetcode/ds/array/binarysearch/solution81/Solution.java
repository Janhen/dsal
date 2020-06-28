package com.janhen.coding.leetcode.ds.array.binarysearch.solution81;

class Solution {
  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return false;

    int firstIndex = findMinInDuplicateRotateArray(nums);
    int idx = binarySearchWithOffset(nums, firstIndex, target);
    return idx != -1;
  }

  private int findMinInDuplicateRotateArray(int[] nums) {
    int lo = 0, hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] == nums[lo] && nums[mid] == nums[hi])
        return getMinIndex(nums, lo, hi);

      if (nums[mid] <= nums[hi]) hi = mid;   // [mid] in sub2, first int left half, first can be [mid]
      else lo = mid + 1;
    }
    return lo;
  }

  // case1: [1,1,3,1] 3
  // case2: [1,1,0,1] 2
  // case3: [1,1,1,1] 0
  private int getMinIndex(int[] nums, int lo, int hi) {
    for (int i = lo + 1; i < hi; i++) {
      if (nums[i] == nums[lo]) {
        continue;
      } else if (nums[i] < nums[lo]) {     // nums[lo] as excepted
        return i;
      } else {                             // nums[i] > nums[lo]
        for (int j = i + 1; j <= hi; j++)  // find first equal [lo]
          if (nums[j] == nums[lo])
            return j;
      }
    }
    return lo;
  }

  private int binarySearchWithOffset(int[] nums, int offset, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int realMid = (mid + offset) % nums.length;
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