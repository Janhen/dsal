package com.janhen.coding.leetcode.ds.array.solution718;

public class Solution2 {

  // time: O(N×M), space: O(N×M)
  public int findLength(int[] A, int[] B) {
    int n = A.length, m = B.length;
    int[][] dp = new int[n + 1][m + 1];
    int ret = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
        ret = Math.max(ret, dp[i][j]);
      }
    }
    return ret;
  }
}
