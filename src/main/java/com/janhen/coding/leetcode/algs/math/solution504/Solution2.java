package com.janhen.coding.leetcode.algs.math.solution504;

public class Solution2 {
  public String convertToBase7(int n) {
    if (n < 0)
      return "-" + convertToBase7(-n);
    if (n < 7)
      return Integer.toString(n);
    return convertToBase7(n / 7) + n % 7;
  }
}
