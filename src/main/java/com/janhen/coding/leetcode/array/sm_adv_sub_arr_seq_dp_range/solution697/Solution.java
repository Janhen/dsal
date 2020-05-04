package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution697;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        Map<Integer, Integer> numLastIndex = new HashMap<>();    // current last occur position
        Map<Integer, Integer> numFirstIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);
            numLastIndex.put(num, i);
            if (!numFirstIndex.containsKey(num)) numFirstIndex.put(num, i);
        }
        // step2: find maxCnt val and index
        int maxFreq = freqs.values().stream().max(null).get();

        // step3: find min short in many max frequency
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            if (freqs.get(nums[i]) != maxFreq) continue;
            minLen = Math.min(minLen, numLastIndex.get(nums[i]) - numFirstIndex.get(nums[i]) + 1);
        }
        return minLen;
    }
}