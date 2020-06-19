package com.janhen.coding.leetcode.other.topinterview.solution7;

class Solution {
  public int reverse(int x) {
    int val = 0;
    while (x != 0) {
      // this condition checks for overflow
      if (val > Integer.MAX_VALUE / 10 || val < Integer.MIN_VALUE / 10)
        return 0;
      val = val * 10 + x % 10;
      x /= 10;
    }
    return val;
  }
}
