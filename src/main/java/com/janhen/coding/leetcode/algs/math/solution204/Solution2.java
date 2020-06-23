package com.janhen.coding.leetcode.algs.math.solution204;

import java.util.Arrays;

public class Solution2 {
  int countPrimes(int n) {
    boolean[] isPrim = new boolean[n];
    Arrays.fill(isPrim, true);
    for (int i = 2; i * i < n; i++)
      if (isPrim[i])
        for (int j = i * i; j < n; j += i)
          isPrim[j] = false;

    int count = 0;
    for (int i = 2; i < n; i++)
      if (isPrim[i]) count++;

    return count;
  }
}
