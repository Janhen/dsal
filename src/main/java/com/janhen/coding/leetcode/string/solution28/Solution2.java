package com.janhen.coding.leetcode.string.solution28;

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

class Solution2 {
  public int strStr(String haystack, String needle) {
    int l1 = haystack.length(), l2 = needle.length();
    if (l1 < l2) {
      return -1;
    } else if (l2 == 0) {
      return 0;
    }
    int threshold = l1 - l2;
    for (int i = 0; i <= threshold; ++i) {
      if (haystack.substring(i,i+l2).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
}