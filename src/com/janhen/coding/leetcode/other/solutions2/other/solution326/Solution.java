package com.janhen.coding.leetcode.other.solutions2.other.solution326;

// 12 ms, faster than 99.94%
class Solution {
  public boolean isPowerOfThree(int n) {
    if (n == 1)
      return true;
    while (n != 0) {
      if (n == 3) return true;
      if (n % 3 == 0) n /= 3;
      else return false;
    }
    return false;
  }
}