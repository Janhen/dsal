package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution581;

import java.util.Arrays;

class Solution {
  // compare ordered array
  public int findUnsortedSubarray(int[] nums) {
    // 1. aux record ordered array
    int[] aux = nums.clone();
    Arrays.sort(aux);

    // 2. find first not correct index From left to right
    int start = 0;
    while (start < nums.length && nums[start] == aux[start])
      start++;

    // 3. find first not in correct position index From right to left
    int end = nums.length - 1;
    while (end > start && nums[end] == aux[end])
      end--;

    return end - start + 1;
  }
}