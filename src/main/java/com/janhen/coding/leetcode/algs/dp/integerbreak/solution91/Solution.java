package com.janhen.coding.leetcode.algs.dp.integerbreak.solution91;

class Solution {
  /*
  处理 0 的特殊性
   */
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) return 0;
    if (s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;

    int n = s.length();
    int[] dp = new int[n];
    dp[0] = isValid(s, 0, 0) ? 1 : 0;
    dp[1] = (isValid(s, 1, 1) ? dp[0] : 0) + (isValid(s, 0, 1) ? 1 : 0);    // handle Ternary operator
    for (int i = 2; i < s.length(); i ++) {
      // one bit, not valid to continue
      dp[i] += isValid(s, i, i) ? dp[i - 1] : 0;
      // two bit
      dp[i] += isValid(s, i-1, i) ? dp[i - 2] : 0;
    }
    return dp[n - 1];
  }

  // judge 00-99 is or not can decode character
  private boolean isValid(String str, int i, int j) {
    if (i == j)
      return str.charAt(i) != '0';
    int num = Integer.parseInt(str.substring(i, j + 1));
    return num >= 10 && num <= 26;
  }

}