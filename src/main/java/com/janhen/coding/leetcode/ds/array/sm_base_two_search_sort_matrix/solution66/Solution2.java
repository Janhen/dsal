package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution66;

class Solution2 {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += carry;
      if (digits[i] <= 9)
        return digits;
      digits[i] = 0;
    }
    int[] nums = new int[digits.length + 1];
    nums[0] = 1;
    return nums;
  }
}