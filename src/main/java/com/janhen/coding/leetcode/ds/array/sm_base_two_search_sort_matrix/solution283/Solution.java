package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        // sequential set value
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0)
                nums[k ++] = nums[i];
        // set tail elements to 0
        Arrays.fill(nums, k, nums.length, 0);
    }
}