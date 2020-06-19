package com.janhen.coding.leetcode.hashtable.practice.solution205;

//  205. Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/
// Easy
// Hash Table

/*
判断字符串同构

Input: s = "egg", t = "add"
Output: true

Input: s = "foo", t = "bar"
Output: false

Input: s = "paper", t = "title"
Output: true
 */

/*
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
 */
class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] hash1 = new int[256];      // record position as unique identifier
        int[] hash2 = new int[256];
        for (int i = 0; i < s.length(); i ++) {
            if (hash1[s.charAt(i)] != hash2[t.charAt(i)])
                return false;
            hash1[s.charAt(i)] = i + 1;
            hash2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}