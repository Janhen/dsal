package com.janhen.coding.leetcode.algs.sort.solution451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    public String frequencySort(String s) {
        // 1. frequency statistics
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s.toCharArray())
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);

        // 2. bucket sort
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char key : freqs.keySet()) {
            int freq = freqs.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        // 3. build result by char[]
        char[] chs = s.toCharArray();
        int k = 0;
        for (int freq = buckets.length - 1; freq > 0; freq--) {
            if (buckets[freq] == null) continue;
            for (char val : buckets[freq]) {
                for (int i = 0; i < freq; i++)
                    chs[k++] = val;
            }
        }
        return new String(chs);
    }
}