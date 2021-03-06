package com.janhen.coding.leetcode.algs.math.solution168;

public class Solution {
  public String convertToTitle(int n) {
    if (n == 0) {
      return "";
    }
    // from 1 begin
    n--;
    return convertToTitle(n / 26) + (char) (n % 26 + 'A');
  }
}
