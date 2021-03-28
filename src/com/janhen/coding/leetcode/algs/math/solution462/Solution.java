package com.janhen.coding.leetcode.algs.math.solution462;

public class Solution {
  // time: O(N)
  public int minMoves2(int[] nums) {
    int move = 0;
    // 1. find median
    int median = findKthSmallest(nums, nums.length / 2);
    // 2. iterate to collect diff distance
    for (int num : nums) {
      move += Math.abs(num - median);
    }
    return move;
  }

  private int findKthSmallest(int[] nums, int k) {
    int l = 0, h = nums.length - 1;
    while (l < h) {
      int j = partition(nums, l, h);
      if (j == k) {
        break;
      }
      if (j < k) {
        l = j + 1;
      } else {
        h = j - 1;
      }
    }
    return nums[k];
  }

  private int partition(int[] nums, int l, int h) {
    int i = l, j = h + 1;
    while (true) {
      while (nums[++i] < nums[l] && i < h) ;
      while (nums[--j] > nums[l] && j > l) ;
      if (i >= j) {
        break;
      }
      swap(nums, i, j);
    }
    swap(nums, l, j);
    return j;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
