package com.janhen.coding.leetcode.ds.hashtable.practice.solution594;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        int longest = 0;
        for (Integer num : freqs.keySet()) {
            Integer freq = freqs.get(num);
            if (freqs.containsKey(num + 1)) {
                longest = Math.max(longest, freq + freqs.get(num + 1));
            }
        }
        return longest;
    }
}