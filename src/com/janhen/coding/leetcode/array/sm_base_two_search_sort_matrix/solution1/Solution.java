package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIdxMap = new HashMap<>(nums.length *3/4);
        for (int i = 0; i < nums.length; i ++) {
            if (valIdxMap.containsKey(target - nums[i]))
                return new int[]{valIdxMap.get(target-nums[i]), i};
            valIdxMap.put(nums[i], i);
        }
        throw new IllegalStateException();
    }
}
 