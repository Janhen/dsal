package com.janhen.coding.leetcode.dp.maxsubarray.solution53;

class SolutionF {
  public int maxSubArray(int[] nums) {
    // record before max Sum
    int preSum = nums[0];
    int maxSum = preSum;
    for (int i = 1; i < nums.length; i++) {
      // reset to from one position to begin OR continous sub array
      preSum = (preSum > 0) ? preSum + nums[i] : nums[i];
      maxSum = Math.max(preSum, maxSum);
    }
    return maxSum;
  }
}
