package com.janhen.coding.leetcode.ds.stackqueue.sm_nested_ugly_diff_polish_decode_next.solution313;

class Solution {

    //  15 ms, faster than 80.46%
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] idx = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {            // from 1 begin
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
            }

            for (int j = 0; j < primes.length; j++) {
                while (dp[idx[j]] * primes[j] <= dp[i])
                    idx[j]++;
            }
        }
        return dp[n - 1];
    }
}