package com.janhen.leetcode.a_base.solution53;

class SolutionF {
    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i ++) {
            preSum = (preSum > 0) ? preSum + nums[i] : nums[i];   // reset to from one position to begin OR continous sub array
            maxSum = Math.max(preSum, maxSum);
        }
        return maxSum;
    }
}
