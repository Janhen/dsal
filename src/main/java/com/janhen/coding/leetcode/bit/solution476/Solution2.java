package com.janhen.coding.leetcode.bit.solution476;

public class Solution2 {
  // Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数
  public int findComplement(int num) {
    if (num == 0) return 1;
    int mask = Integer.highestOneBit(num);
    mask = (mask << 1) - 1;
    return num ^ mask;
  }
}
