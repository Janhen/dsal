package com.janhen.coding.leetcode.algs.math.solution172;

public class Solution {
  /*
  尾部的 0 由 2 * 5 得来，2 的数量明显多于 5 的数量，因此只要统计有多少个 5 即可。

  对于一个数 N，它所包含 5 的个数为：N/5 + N/5^2 + N/5^3 + ...，
  其中 N/5 表示不大于 N 的数中 5 的倍数贡献一个 5，
  N/5^2 表示不大于 N 的数中 5^2 的倍数再贡献一个 5 ...

  如果统计的是 N! 的二进制表示中最低位 1 的位置，只要统计有多少个 2 即可
   */
  public int trailingZeroes(int n) {
    if (n == 0) {
      return 0;
    }
    return n / 5 + trailingZeroes(n / 5);
  }
}
