package com.janhen.coding.leetcode.ds.hashtable.solution454;

import java.util.HashMap;
import java.util.Map;

class Solution {

  // A[i] + B[j] + C[k] + D[l] = 0
  // ───────────   ───────────
  //     P              P`
  // P + P` = 0                P represent (A[i] + B[j] ), P` represent (C[k] + D[l] )

  // 只求出有多少种可能, 无需将每个结果给出
  // 105 ms, faster than 74.82%
  // time : O(n^2)  space : O(n^2)
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    // A[i] + A[j] -> freq
    Map<Integer, Integer> freqs = new HashMap<>();
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int key = C[i] + D[j];
        freqs.put(key, freqs.getOrDefault(key, 0) + 1);
      }
    }
    int ret = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int key = 0 - A[i] - B[j];
        if (freqs.containsKey(key)) {
          ret += freqs.get(key);
        }
      }
    }
    return ret;
  }
}