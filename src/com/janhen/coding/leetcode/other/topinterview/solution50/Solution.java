package com.janhen.coding.leetcode.other.topinterview.solution50;

public class Solution {

  // FIXME
  // 2.00000
  //-2147483648
  public double myPow(double base, int exponent) {
    if (exponent == 0)
      return 1;
    if (exponent == 1)
      return base;

    boolean isNegative = exponent < 0;
    exponent = isNegative ? -exponent : exponent;

    double pow = myPow(base, exponent / 2);
    pow = exponent % 2 != 0 ? pow * pow * base : pow * pow;

    return isNegative ? 1.0 / pow : pow;
  }
}
