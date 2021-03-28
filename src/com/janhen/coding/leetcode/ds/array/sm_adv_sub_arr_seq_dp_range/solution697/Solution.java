package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution697;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int findShortestSubArray(int[] nums) {
    // step1: collect necessary information
    // num -> freq
    Map<Integer, Integer> freqs = new HashMap<>();
    // num -> firstOccurIdx
    Map<Integer, Integer> numLastIdx = new HashMap<>();
    // num -> lastOccurIdx
    Map<Integer, Integer> numFirstIdx = new HashMap<>();

    // init all map
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      freqs.put(num, freqs.getOrDefault(num, 0) + 1);
      numLastIdx.put(num, i);
      if (!numFirstIdx.containsKey(num)) {
        numFirstIdx.put(num, i);
      }
    }

    // step2: find maxCnt val and index
    int maxFreq = freqs.values().stream().max(null).get();

    // step3: find min short in many duplicate max frequency
    int minLen = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (freqs.get(nums[i]) != maxFreq)
        continue;
      minLen = Math.min(minLen, numLastIdx.get(nums[i]) - numFirstIdx.get(nums[i]) + 1);
    }
    return minLen;
  }
}