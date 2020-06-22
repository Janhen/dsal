package com.janhen.coding.leetcode.algs.dp.knapsack.solution494;

class SolutionBF {
    // S, index
    // 二维表, S 可为负数
    // index as row, S as col, val is possible sum number
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }

    private int findTargetSumWays(int[] nums, int S, int index) {
        if (index == nums.length) {                // S can be - in running
            return S == 0 ? 1 : 0;
        }
        int res = 0;
        res += findTargetSumWays(nums, S - nums[index], index + 1);
        res += findTargetSumWays(nums, S + nums[index], index + 1);
        return res;
    }
}