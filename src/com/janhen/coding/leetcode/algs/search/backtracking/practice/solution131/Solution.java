package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution131;

import java.util.ArrayList;
import java.util.List;

// todo Q
class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    if (s == null || s.length() == 0)
      return res;
    backtracking(s, 0, new ArrayList<>(), res);
    return res;
  }

  private void backtracking(String s, int start, List<String> list, List<List<String>> res) {
    if (start == s.length()) {
      res.add(new ArrayList<>(list));
      return;
    }
    String substr = "";
    for (int i = start + 1; i <= s.length(); i++) {
      substr = s.substring(start, i);
      if (isPalindrome(substr)) {
        list.add(substr);
        backtracking(s, i, list, res);
        list.remove(list.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String str) {
    int i = 0, j = str.length() - 1;
    while (i < j) {
      if (str.charAt(i++) != str.charAt(j--))
        return false;
    }
    return true;
  }
}