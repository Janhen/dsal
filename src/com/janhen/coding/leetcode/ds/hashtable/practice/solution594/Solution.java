package com.janhen.coding.leetcode.ds.hashtable.practice.solution594;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int findLHS(int[] nums) {
        final Map<Integer, Integer> freqs = Arrays.stream(nums).boxed().collect(Collectors.toMap(Function.identity(),
          val -> 1, Integer::sum));

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