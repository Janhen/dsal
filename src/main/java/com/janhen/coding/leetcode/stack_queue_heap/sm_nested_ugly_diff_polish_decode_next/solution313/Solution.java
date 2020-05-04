package main.java.janhen.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution313;

// 313. Super Ugly Number
//https://leetcode.com/problems/super-ugly-number/

/*
超级丑数
Medium

310

78

Favorite

Share
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.
Note:

1 is a super ugly number for any given primes.
The given numbers in primes are in 【ascending order】.
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */

class Solution {

    //  15 ms, faster than 80.46%
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] idx = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i ++) {            // from 1 begin
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j ++) {
                dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
            }

            for (int j = 0; j < primes.length; j ++) {
                while (dp[idx[j]] * primes[j] <= dp[i])
                    idx[j] ++;
            }
        }
        return dp[n-1];
    }
}