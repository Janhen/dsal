package com.janhen.coding.leetcode.algs.math.solution204;

import java.util.Arrays;

public class Solution {
  int countPrimes(int n) {
    // 1. init prim record
    boolean[] isPrim = new boolean[n];
    Arrays.fill(isPrim, true);
    // 2. i*i < n to prevent outOfInt ...
    for (int i = 2; i * i < n; i++) {
      if (isPrim[i]) {
        // 3. set current prim exact division number
        // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
        for (int j = i * i; j < n; j += i)
          isPrim[j] = false;
      }
    }
    // 4. collect prim count
    int count = 0;
    for (int i = 2; i < n; i++)
      if (isPrim[i])
        count++;
    return count;
  }
}
