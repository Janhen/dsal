package com.janhen.coding.leetcode.other.topinterview.solution50;

public class Solution2 {

  public double myPow(double x, int n) {
    if (n == 0)
      return 1;
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
  }
}
