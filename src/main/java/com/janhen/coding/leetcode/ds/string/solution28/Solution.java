package com.janhen.coding.leetcode.ds.string.solution28;

// 28. Implement strStr()
//https://leetcode.com/problems/implement-strstr/
// Easy 732:1134



/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */

class Solution {
  public int strStr(String s, String t) {
    // edge case: "",""=>0  "a",""=>0
    if (t.isEmpty())
      return 0;
    for (int i = 0; i <= s.length() - t.length(); i++) {
      for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
        if (j == t.length() - 1) return i;
    }
    return -1;
  }
}