package com.janhen.coding.leetcode.ds.hashtable.practice.solution290;

//  290. Word Pattern
// https://leetcode.com/problems/word-pattern/
// Easy
// Hash Table

/*
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
import java.util.Objects;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {            // why `Integer`,  `int` can not
            Integer idx1 = map1.put(pattern.charAt(i), i);
            Integer idx2 = map2.put(words[i], i);
            if (!Objects.equals(idx1, idx2)) {
                return false;
            }
        }
        return true;
    }
}