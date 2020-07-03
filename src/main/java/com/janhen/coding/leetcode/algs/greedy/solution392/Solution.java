package com.janhen.coding.leetcode.algs.greedy.solution392;

public class Solution {
  public boolean isSubsequence(String s, String t) {
    int index = -1;
    // find every character in t string
    for (char c : s.toCharArray()) {
      // from [index + 1] to make sure original order
      index = t.indexOf(c, index + 1);
      if (index == -1) {
        return false;
      }
    }
    return true;
  }
}
