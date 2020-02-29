package com.janhen.leetcode.search.practice.solution290;

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

class Solution_my {

    // 1 ms, faster than 99.28%
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;
        OneToOneMap<Character, String> map = new OneToOneMap();
        for (int i = 0; i < pattern.length(); i ++) {
            if (!map.put(pattern.charAt(i), words[i]))
                return false;
        }
        return true;
    }


    class OneToOneMap<K, V> {
        private Map<K, V> map = new HashMap<>();

        public V get(K key) {
            return map.get(key);
        }

        // is unique
        public boolean put(K key, V val) {
            if (map.containsKey(key)) {
                if (!map.get(key).equals(val))
                    return false;
            } else {
                if (map.containsValue(val))
                    return false;
                map.put(key, val);
            }
            return true;
        }
    }
}