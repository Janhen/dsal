package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // sequential coverage
        int k = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i == 0 || nums[i] != nums[i - 1])   // init and condition
                nums[k ++] = nums[i];
        }
        return k;
    }
}

