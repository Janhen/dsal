package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution229;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // TOWHY
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;

    int candidate1 = nums[0], candidate2 = nums[0];
    int count1 = 0, count2 = 0;    // iterate from 0 to len, need initialize as 0
    for (int num : nums) {     // must if
      if (num == candidate1) {
        count1++;
      } else if (num == candidate2) {
        count2++;
      } else if (count1 == 0) {           // need to reset
        candidate1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    count1 = count2 = 0;           // find candidate frequency
    for (int num : nums) {
      if (num == candidate1)
        count1++;
      else if (num == candidate2)
        count2++;
    }
    if (count1 > nums.length / 3) res.add(candidate1);
    if (count2 > nums.length / 3) res.add(candidate2);
    return res;
  }
}