package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution189;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;

        int n = nums.length;
        // prevent unnecessary rotate
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j)
            swap(nums, i++, j--);
    }

    // int to swap
    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}