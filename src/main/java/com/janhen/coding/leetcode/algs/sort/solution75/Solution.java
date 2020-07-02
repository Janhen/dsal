package com.janhen.coding.leetcode.algs.sort.solution75;

class Solution {
  /*
  [0.....lt, lt+1,....i-1, i, i+1, ... gt-1, gt,...n-1]
      <v   |      =v     |    |            |    >v
  [0...lt] < v
  [lt+1,i-1] = v
  [i] cur iterate element
  [i+1,gt-1] to be iterate
  [gt...n-1] > v
   */
  public void sortColors(int[] nums) {
    // not include border
    int lt = -1, gt = nums.length;
    int i = 0;
    int pivot = 1;
    while (i < gt) {
      if (nums[i] == pivot)
        i++;
      else if (nums[i] < pivot)
        swap(nums, i++, ++lt);
      else
        swap(nums, i, --gt);
    }
  }

  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}