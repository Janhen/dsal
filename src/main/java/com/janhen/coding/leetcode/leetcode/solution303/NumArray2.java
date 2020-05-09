package com.janhen.coding.leetcode.leetcode.solution303;

public class NumArray2 {

    private int[] sums; // sum[i]存储前i个元素和, sum[0] = 0
                        // 即sum[i]存储nums[0...i-1]的和
                        // sum(i, j) = sum[j + 1] - sum[i]

    public NumArray2(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i ++)
            sums[i] = sums[i - 1] + nums[i - 1];
    }

    // sum[j+1]   nums[0] [1] [2] ... [j]
    // sum[i]     nums[0] [1] [2] ... [i-1]
    // sub        nums[i] [i+1] ... [j]
    public int sumRange(int i, int j) {

        return sums[j + 1] - sums[i];
    }
}