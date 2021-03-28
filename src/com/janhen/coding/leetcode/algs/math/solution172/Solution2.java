package com.janhen.coding.leetcode.algs.math.solution172;

public class Solution2 {
  public int trailingZeroes(int n) {
    int result = 0;
    for (long i = 5; n / i > 0; i *= 5) {
      result += (n / i);
    }
    return result;
  }
}
