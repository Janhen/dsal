package com.janhen.coding.leetcode.algs.math.solution168;

public class Solution2 {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      n--;
      sb.insert(0, (char) ('A' + n % 26));
      n /= 26;
    }
    return sb.toString();
  }
}
