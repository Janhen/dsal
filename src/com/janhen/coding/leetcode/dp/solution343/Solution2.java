package com.janhen.leetcode.dp.solution343;

// 14 减绳子
//分析：
//使用 f(n) 代表长度为 n 的绳子被剪成若干段之后相乘的最大值；
//减第一刀的时候，有 n - 1 种可能，分别在长度为 1, 2, 3, ... , n - 1 处切断；
//因而有 递归公式 ：  f(n) = max( f(i) * f(n - i) )     ( 0 < i < n)
public class Solution2 {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {        // 相乘的对称性
                max = Math.max(max, dp[j] * dp[i - j]);   // dp[j] 包含部分割情况,  dp[j]*dp[i-j] 包含只分割一次的情况
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
