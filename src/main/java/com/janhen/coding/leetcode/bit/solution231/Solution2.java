package com.janhen.coding.leetcode.bit.solution231;

public class Solution2 {
//  利用 1000 & 0111 == 0 这种性质，得到以下解法：

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
