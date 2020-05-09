package com.janhen.coding.leetcode.dp.practice.solution413;

import java.util.Arrays;

class SolutionDP {
    // 在 A[i] - A[i - 1] == A[i - 1] - A[i - 2] 的条件下，
    // {A[i - 2], A[i - 1], A[i]} 是一个等差递增子区间。
    // 如果 {A[i - 3], A[i - 2], A[i - 1]} 是一个等差递增子区间，
    // 那么 {A[i - 3], A[i - 2], A[i - 1], A[i]} 也是等差递增子区间，dp[i] = dp[i-1] + 1。

    // pre 为等差,  当前位等差 pre + 1
    // pre 不为等差,当前为等差 1
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int[] dp = new int[A.length];       // dp[i] 表示 [i] 为结尾数组的等差区间个数
        if (A[2]- A[1] == A[1]-A[0]) dp[2] = 1;
        for (int i = 3; i < A.length; i ++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2])     // cur is arithmetic
                dp[i] = dp[i-1] + 1;
        }
        return Arrays.stream(dp).sum();
    }
}