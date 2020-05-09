package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution697;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution_my {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        Map<Integer, Integer> numFirstIdxMap = new HashMap<>();
        Map<Integer, Integer> numLastIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            freqs.put(nums[i], freqs.getOrDefault(nums[i], 0) + 1);
            numLastIdxMap.put(nums[i], i);
            if (!numFirstIdxMap.containsKey(nums[i])) {
                numFirstIdxMap.put(nums[i], i);
            }
        }
//        int maxFreq = freqs.values().stream().max((o1, o2) -> Integer.compare(o1, o2)).get();
        int maxFreq = freqs.values().stream().max(Comparator.comparingInt(null)).get();
        int minLen = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (freqs.get(nums[i]) != maxFreq)
                continue;
            minLen = Math.min(minLen, numLastIdxMap.get(nums[i]) - numFirstIdxMap.get(nums[i]) + 1);
        }
        return minLen;
    }
}
