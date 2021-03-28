package com.janhen.coding.leetcode.algs.math.solution67;

class Solution {
  // note: char not int, need to cast to int, then compute
  public String addBinary(String A, String B) {
    StringBuilder builder = new StringBuilder();
    // 1. from low bit to high bit
    int i = A.length() - 1, j = B.length() - 1;
    int carry = 0;
    // 2. iterate to build result
    while (i >= 0 || j >= 0) {
      // 3. calculate current bit value
      int val = (i >= 0 ? A.charAt(i--) - '0' : 0)
        + (j >= 0 ? B.charAt(j --) - '0' : 0)
        + carry;
      // 4. collect val and set carry
      if (val > 1) {
        carry = 1;
        builder.append(val % 2);
      } else {
        carry = 0;   // reset carry
        builder.append(val);
      }
    }
    // 5. handle tail high bit
    if (carry == 1)
      builder.append(carry);
    // 6. return result
    return builder.reverse().toString();
  }
}