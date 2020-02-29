package com.janhen.swordoffer.recursiont_dp.problem14;

public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int max = -1;
            for (int j = 1; j < i; j ++) {   // split in 1,2,3...i-1 position
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;      // split i, max can multiply
        }
        return dp[n];
    }
}
