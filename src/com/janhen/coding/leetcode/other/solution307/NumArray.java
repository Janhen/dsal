package com.janhen.coding.leetcode.other.solution307;

// 307. Range Sum Query - Mutable
// https://leetcode.com/problems/range-sum-query-mutable/description/
// medium

class NumArray {

    // add auxiliary data structures
    private int[] sum;
    private int[] data;

    public NumArray(int[] nums) {
        data = nums.clone();

        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    // update data array value
    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j ++) {
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}