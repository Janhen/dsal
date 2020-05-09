package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution283;

import java.util.Arrays;

class Solution_my {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0)
                nums[k ++] = nums[i];
        Arrays.fill(nums, k, nums.length, 0);
    }
}