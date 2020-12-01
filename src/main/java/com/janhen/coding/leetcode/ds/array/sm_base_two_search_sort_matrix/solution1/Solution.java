package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution1;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    // num -> idx
    Map<Integer, Integer> valIdxMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int targetKey = target - nums[i];
      if (valIdxMap.containsKey(targetKey)) {
        return new int[]{valIdxMap.get(targetKey), i};
      }
      valIdxMap.put(nums[i], i);
    }
    throw new IllegalArgumentException("No result");
  }
}