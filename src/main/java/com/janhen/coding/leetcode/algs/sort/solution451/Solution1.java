package com.janhen.coding.leetcode.algs.sort.solution451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 19 ms, faster than 85.88%
class Solution1 {

    // 按照字符出现次数对字符串排序
    // StringBuilder 拼接结果
    public String frequencySort(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : s.toCharArray())
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);

        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char key : freqs.keySet()) {
            int freq = freqs.get(key);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();                    // string buffer append
        for (int freq = buckets.length - 1; freq > 0; freq --) {
            if (buckets[freq] == null) continue;
            for (char val : buckets[freq]) {
                for (int i = 0; i < freq; i ++)
                    sb.append(val);
            }
        }
        return sb.toString();
    }
}