package com.janhen.coding.leetcode.algs.math.solution415;

public class Solution {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
    while (carry == 1 || i >= 0 || j >= 0) {
      int val = (i < 0 ? 0 : num1.charAt(i--) - '0')
        + j < 0 ? 0 : num2.charAt(j--) - '0'
        + carry;
      carry = carry / 10;
      sb.append(val % 10);
    }
    return sb.reverse().toString();
  }
}
