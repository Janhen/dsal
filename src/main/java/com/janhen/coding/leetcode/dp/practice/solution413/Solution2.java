package com.janhen.coding.leetcode.dp.practice.solution413;

class Solution2 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;
        int cur = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i ++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                cur += 1;
                sum += cur;
            } else cur = 0;
        }
        return sum;
    }
}