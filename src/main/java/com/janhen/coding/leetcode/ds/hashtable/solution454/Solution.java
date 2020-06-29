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
    // 保存 C + D 的可能性
    Map<Integer, Integer> recordCD = new HashMap<>();
    for (int i = 0; i < C.length; i++) {
      for (int j = 0; j < D.length; j++) {
        int key = C[i] + D[j];
        recordCD.put(key, recordCD.getOrDefault(key, 0) + 1);
      }
    }
    int res = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        int key = 0 - A[i] - B[j];
        if (recordCD.containsKey(key)) // corresponding can come to result constraint
          res += recordCD.get(key);
      }
    }
    return res;
  }
}