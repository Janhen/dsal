package com.janhen.coding.leetcode.algs.sort.solution75;

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, lt = -1, gt = nums.length;
        int pivot = 1;
        while (i < gt) {
            if (nums[i] == pivot)
                i++;
            else if (nums[i] < pivot)
                swap(nums, i++, ++lt);
            else
                swap(nums, i, --gt);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}