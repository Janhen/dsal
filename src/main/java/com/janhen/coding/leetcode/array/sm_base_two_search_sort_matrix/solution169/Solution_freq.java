package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution169;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Solution_freq {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        Optional<Map.Entry<Integer, Integer>> first = freqs.entrySet().stream().filter(entry -> entry.getValue() > nums.length / 2).findFirst();
        return first.isPresent() ? first.get().getKey() : -1;
    }
}