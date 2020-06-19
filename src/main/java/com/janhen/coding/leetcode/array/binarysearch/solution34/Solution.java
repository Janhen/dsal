package com.janhen.coding.leetcode.array.binarysearch.solution34;

class Solution {

  // first occur index to reduce last search range
  public int[] searchRange(int[] nums, int target) {
    int first = binarySearchFirst(nums, 0, nums.length - 1, target);
    if (first < 0)
      return new int[]{-1, -1};

    // reduce search range
    int last = binarySearchLast(nums, first, nums.length - 1, target);
    return new int[]{first, last};
  }

  private int binarySearchFirst(int[] nums, int L, int R, int target) {
    while (L <= R) {
      int mid = L + (R - L) / 2;
      // first index in duplication array that equal specify the number
      if (nums[mid] == target) {
        if (mid == 0 || (mid > 0 && nums[mid - 1] != nums[mid]))
          return mid;
        else
          R = mid - 1;
      } else if (nums[mid] < target) {
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    return -1;
  }

  private int binarySearchLast(int[] nums, int L, int R, int target) {
    while (L <= R) {
      int mid = L + (R - L) / 2;
      if (nums[mid] == target) {
        if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
          return mid;
        else
          L = mid + 1;
      } else if (nums[mid] < target) {
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    return -1;
  }
}