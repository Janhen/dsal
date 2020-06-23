package com.janhen.coding.leetcode.algs.math.solution169;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        Optional<Map.Entry<Integer, Integer>> first = freqs.entrySet().stream().filter(entry -> entry.getValue() > nums.length / 2).findFirst();
        return first.isPresent() ? first.get().getKey() : -1;
    }
}