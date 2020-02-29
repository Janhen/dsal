package com.janhen.leetcode.dp.practice.solution303;

class NumArray1_ {

    int[] sums;

    public NumArray1_(int[] nums) {
        sums = nums.clone();
        for (int i = 1; i < nums.length; i ++) {
            sums[i] = sums[i] + sums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sums[j];
        return sums[j] - sums[i-1];
    }
}