package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution338;

class SolutionF {
    //    对于数字 6(110)，它可以看成是 4(100) 再加一个 2(10)，因此 dp[i] = dp[i&(i-1)] + 1;
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i ++)
            dp[i] = dp[i&(i-1)]  + 1;
        return dp;
    }
}