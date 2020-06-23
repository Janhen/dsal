package com.janhen.coding.leetcode.ds.hashtable.practice.solution290;

//  290. Word Pattern
// https://leetcode.com/problems/word-pattern/
// Easy
// Hash Table

/*
判断单词是否与指定模式匹配
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
 */

import java.util.HashMap;
import java.util.Map;

class Solution3 {

    // 1 ms, faster than 99.28%
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i ++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(words[i]))    // x, y    have x, then y must y
                    return false;
            } else {
                if (map.containsValue(words[i]))       // not have x, then not have y
                    return false;
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}