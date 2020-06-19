package com.janhen.coding.leetcode.stackqueue.stack.solution442;

import java.util.ArrayList;
import java.util.List;

/*
元素范围 1_n 找出重复的元素
*/
class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      // not in element should put position
      while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < nums.length; i++)
      // not in element where it should be
      if (nums[i] != i + 1)
        res.add(nums[i]);
    return res;
  }

  private void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}