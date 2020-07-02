package com.janhen.coding.leetcode.ds.tree.sm_two_sub_sequence_convert_path.solution96;

class Solution {
  // TODO
  //  h(n) = h(0)*h(n-1) + h(1)*h(n-2) + ... + h(n-1)h(0) (其中n>=2) ，
  // NOTE: null as left OR null as right is one possibility
  int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] = dp[i] + dp[j - 1] * dp[i - j];   // NOTE: [j-1] AS left sub tree, [i-j] AS right sub tree
      }
    }
    return dp[n];
  }
}