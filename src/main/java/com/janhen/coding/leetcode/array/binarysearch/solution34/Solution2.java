package com.janhen.coding.leetcode.array.binarysearch.solution34;

// 34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
//Medium 32.7%
//Array Binary Search

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

//  4 ms, faster than 63.77%
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