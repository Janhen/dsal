package com.janhen.coding.leetcode.ds.bit.solution476;

public class Solution3 {
  /*
  对于 10000000 这样的数要扩展成 11111111，可以利用以下方法：

mask |= mask >> 1    11000000
mask |= mask >> 2    11110000
mask |= mask >> 4    11111111
   */
  public int findComplement(int num) {
    int mask = num;
    mask |= mask >> 1;
    mask |= mask >> 2;
    mask |= mask >> 4;
    mask |= mask >> 8;
    mask |= mask >> 16;
    return (mask ^ num);
  }
}
