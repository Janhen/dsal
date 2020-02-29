package com.janhen.leetcode.top100.recursion_dp_backtracking.solution416;

class SolutionBF {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        return canPartition(nums, 0, sum/2);
    }

    private boolean canPartition(int[] nums, int index, int sum) {
        if (index == nums.length)
            return sum == 0;
        if (sum < 0)
            return false;
        return canPartition(nums, index + 1, sum) || canPartition(nums, index + 1, sum - nums[index]);    // 放入 OR 不放入
    }
}
