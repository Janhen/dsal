package com.janhen.coding.leetcode.dp.practice.solution377;

import java.util.Arrays;

class SolutionMemo {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        return combinationSum4(nums, target, memo);
    }

    public int combinationSum4(int[] nums, int target, int[] memo) {
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (memo[target] != -1) return memo[target];
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            res += combinationSum4(nums, target - nums[i], memo);
        }
        return memo[target] = res;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionMemo()).combinationSum4(new int[] {1,2,3}, 4));
    }
}