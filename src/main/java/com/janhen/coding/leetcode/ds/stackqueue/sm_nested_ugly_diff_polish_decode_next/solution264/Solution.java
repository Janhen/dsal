package com.janhen.coding.leetcode.ds.stackqueue.sm_nested_ugly_diff_polish_decode_next.solution264;

//264. Ugly Number II
//https://leetcode.com/problems/ugly-number-ii/

/*
丑数II
Medium

742p

53

Favorite

Share
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
 */


class Solution {

    // 1, 2, 3, 4, 5,  6,   8,   9, 10,  12
    //    2  3  4  5  2*3 2*2*2 3*3 2*5 2*3*2
    // next = f(2,3,5) = g([x]*2,[y]*3,[z]*5) = min{[x]*2,[y]*3,[z]*5}
    // [x] 为前面以求的结果中 *2 大于当前数的值
    // [y] 为前面以求的结果中 *3 大于当前数的值
    // [z] 为前面以求的结果中 *5 大于当前数的值
    //  5 ms, faster than 56.44%
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int index2=0, index3=0, index5=0;     // index as index, not value
        for (int i = 1; i < n; i++) {
            // cur
            dp[i] = Math.min(dp[index2]*2, Math.min(dp[index3]*3, dp[index5]*5));
            while (dp[index2]*2 <=dp[i])
                index2 ++;
            while (dp[index3]*3 <= dp[i])
                index3 ++;
            while (dp[index5]*5 <= dp[i])
                index5 ++;
        }
        return dp[n-1];
    }
}