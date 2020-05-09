package com.janhen.coding.leetcode.dp.practice.solution377;

class SolutionBF {
    public int combinationSum4(int[] nums, int target) {
        if (target < 0)
            return 0;
        if (target == 0)
            return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            int next = combinationSum4(nums, target - nums[i]);
            res += next;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionBF()).combinationSum4(new int[] {1,2,3}, 4));
    }
}