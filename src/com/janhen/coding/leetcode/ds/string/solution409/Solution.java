package com.janhen.coding.leetcode.ds.string.solution409;

public class Solution {

  public int longestPalindrome(String s) {
    int[] freqs = new int[256];
    for (char c : s.toCharArray())
      freqs[c]++;

    // 1. select even
    int maxLen = 0;
    for (int freq : freqs)
      maxLen += (freq / 2) * 2;
    // 2. handle select one middle element
    if (maxLen < s.length())
      maxLen++;
    return maxLen;
  }
}
