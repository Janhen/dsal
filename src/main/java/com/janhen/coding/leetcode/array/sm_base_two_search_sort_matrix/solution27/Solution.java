package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != val)                     // condition
                nums[k ++] = nums[i];
        return k;
    }
}