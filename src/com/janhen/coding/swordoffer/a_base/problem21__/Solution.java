package com.janhen.coding.swordoffer.a_base.problem21__;

public class Solution {
    // 类似快速排序，找到不满足条件的逆序对进行交换
    public void reOrderArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            // find not meet condition index
            while (nums[lo] % 2 == 1 && lo < hi) lo++;
            while (nums[hi] % 2 == 0 && lo < hi) hi--;

            if (lo < hi) {
                swap(nums, lo, hi);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
