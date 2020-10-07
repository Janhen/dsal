package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution1;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> valIdxMap = new HashMap();
    for (int i = 0; i < nums.length; i++) {
      int findKey = target - nums[i];
      if (valIdxMap.containsKey(findKey)) {
        return new int[]{valIdxMap.get(findKey), i};
      }
      valIdxMap.put(nums[i], i);
    }
    throw new IllegalArgumentException("No result");
  }
}