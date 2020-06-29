package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution1;

import java.util.HashMap;

public class Solution2 {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> record = new HashMap<>();          // key last occur position
    for (int i = 0; i < nums.length; i++)
      record.put(nums[i], i);

    for (int i = 0; i < nums.length; i++)
      if (record.containsKey(target - nums[i]))
        if (record.get(target - nums[i]) != i)      // compare last AND cur position
          return new int[]{i, record.get(target - nums[i])};
    throw new IllegalStateException();
  }
}

