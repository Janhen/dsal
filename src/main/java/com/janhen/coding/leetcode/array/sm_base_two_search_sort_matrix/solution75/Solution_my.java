package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution75;

class Solution_my {
    public void sortColors(int[] nums) {
        int lt = -1, gt = nums.length;
        int i = 0;
        int pivot = 1;
        while (i < gt) {
            if (nums[i] == pivot)
                i ++;
            else if (nums[i] < pivot)
                swap(nums, i ++, ++ lt);
            else
                swap(nums, i, -- gt);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}