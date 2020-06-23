package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution283;


/*
 * 优化处理极端情况: 全部为0      [0,0,0,0]
 * swap : only traverse one time
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0)
                if (k != i) swap(nums, k ++, i);
                else k ++;
        }
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }
}