package com.janhen.coding.leetcode.hashtable.practice.solution242;

// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/
// Easy
// Hash Table, Sort

/*
判断两个字符是否是变位词
变位词问题

Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution15 to such case?
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freqs = new int[26];
        for (char c : s.toCharArray())
            freqs[c-'a'] ++;
        for (char c : t.toCharArray())
            if (-- freqs[c-'a'] < 0)
                return false;
        return true;
    }
}