package main.java.janhen.leetcode.search.practice.solution594;

// 594. Longest Harmonious Subsequence
//https://leetcode.com/problems/longest-harmonious-subsequence/

/*
最长和谐序列
和谐序列中最大数和最小数之差正好为 1，应该注意的是序列的元素不一定是数组的连续元素*/

import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.put(num, freqs.getOrDefault(num, 0) + 1);

        int longest = 0;
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if (freqs.containsKey(entry.getKey() + 1)) {
                longest = Math.max(longest, entry.getValue() + freqs.get(entry.getKey() + 1));
            }
        }
        return longest;
    }
}