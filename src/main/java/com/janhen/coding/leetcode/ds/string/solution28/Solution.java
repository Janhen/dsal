package com.janhen.coding.leetcode.ds.string.solution28;

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