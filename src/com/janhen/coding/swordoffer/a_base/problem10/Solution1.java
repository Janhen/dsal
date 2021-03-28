package com.janhen.coding.swordoffer.a_base.problem10;

public class Solution1 {
  public int fib(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    int res = 0;
    int pre1 = 1;
    int pre2 = 0;
    for (int i = 2; i <= n; i++) {
      res = pre1 + pre2;
      pre2 = pre1;
      pre1 = res;
    }
    return res;
  }

  public int Fibonacci2(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }

  public int Fibonacci3(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return Fibonacci3(n - 1) + Fibonacci3(n - 2);
  }
}
