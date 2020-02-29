package com.janhen.swordoffer.recursiont_dp.problem49;

public class Solution {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6) return N;

        int index2 = 0, index3 = 0, index5 = 0; // record * factor > pre
        int[] dp = new int[N];
        dp[0] = 1;   // 1th
        for (int i = 1; i < N; i ++) {
            int next = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            dp[i] = next;
            while (dp[index2] * 2 <= next)
                index2 ++;
            while (dp[index3] * 3 <= next)
                index3 ++;
            while (dp[index5] * 5 <= next)
                index5 ++;
        }
        return dp[N-1];  // Nth
    }
}
