package com.janhen.coding.leetcode.array.binarysearch.solution34;

class Solution {

  // first occur index to reduce last search range
  public int[] searchRange(int[] nums, int target) {
    int first = binarySearchFirst(nums, 0, nums.length - 1, target);
    int last = binarySearchLast(nums, first, nums.length - 1, target);   // reduce search range
    return new int[]{first, last};
  }

  private int binarySearchFirst(int[] nums, int L, int R, int key) {
    while (L <= R) {
      int mid = L + (R - L) / 2;
      // first index in duplication array that equal specify the number
      if (nums[mid] == key) {
        if (mid == 0 || (mid > 0 && nums[mid - 1] != nums[mid]))
          return mid;
        else
          R = mid - 1;
      } else if (nums[mid] < key) {
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    return -1;
  }

  private int binarySearchLast(int[] nums, int L, int R, int key) {
    if (L < 0)    // use for aim not occur
      return -1;
    while (L <= R) {
      int mid = L + (R - L) / 2;
      if (nums[mid] == key) {
        if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
          return mid;
        else
          L = mid + 1;
      } else if (nums[mid] < key) {
        L = mid + 1;
      } else {
        R = mid - 1;
      }
    }
    return -1;
  }
}