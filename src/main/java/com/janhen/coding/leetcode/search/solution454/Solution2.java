package com.janhen.coding.leetcode.search.solution454;

//454. 4Sum II
//        https://leetcode.com/problems/4sum-ii/description/
// medium

// Given four lists A, B, C, D of integer values,
// compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
//
//To make recursiont_dp a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
// All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
//
//Example:
//
//Input:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//Output:
//2
//
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

import java.util.HashMap;
import java.util.Map;

class Solution2 {

  // 151 ms, faster than 36.32%
  // time : O(n^2)
  // space : O(n^2)
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> mapCD = new HashMap<>(); // len(C) * len(D)
    for (int i = 0; i < C.length; i++)
      for (int j = 0; j < D.length; j++)
        mapCD.put(C[i] + D[j], mapCD.getOrDefault(C[i] + D[j], 0) + 1); // frequency record
    Map<Integer, Integer> mapAB = new HashMap<>();
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < B.length; j++)
        mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);

    int res = 0;
    for (Integer sumAB : mapAB.keySet())
      if (mapCD.containsKey(-sumAB))
        res += mapAB.get(sumAB) * mapCD.get(-sumAB);

    return res;
  }
}