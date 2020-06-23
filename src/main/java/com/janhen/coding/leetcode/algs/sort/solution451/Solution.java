package com.janhen.coding.leetcode.algs.sort.solution451;

// 451. Sort Characters By Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/
//Medium

/*
根据词频排序字符
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 16 ms, faster than 90.82%
class Solution {
    // 按照字符出现次数对字符串排序
    // char[] 数组索引构成结果
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

        char[] chs = s.toCharArray();
        int k = 0;
        for (int freq = buckets.length - 1; freq > 0; freq --) {
            if (buckets[freq] == null) continue;
            for (char val : buckets[freq]) {
                for (int i = 0; i < freq; i ++)
                    chs[k ++] = val;
            }
        }
        return new String(chs);
    }
}