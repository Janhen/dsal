package com.janhen.coding.leetcode.algs.math.solution204;

public class Solution {
  // 埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉
  // https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/da-yin-su-shu
  public int countPrimes(int n) {
    boolean[] notPrimes = new boolean[n + 1];
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (notPrimes[i]) {
        continue;
      }
      count++;
      // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
      for (long j = (long) (i) * i; j < n; j += i) {
        notPrimes[(int) j] = true;
      }
    }
    return count;
  }
}
