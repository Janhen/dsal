package com.janhen.coding.leetcode.dp.solution343;

class Solution {
    // 分割整数
    // dp[i] 表示长度为 i 的绳子分割乘积最大值
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int max = 0;
            for (int j = 1; j < i; j++)
                max = Math.max(max, Math.max(j * (i-j), j * dp[i-j]));
            dp[i] = max;
        }
        return dp[n];
    }
}