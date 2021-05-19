package com.janhen.coding.swordoffer.a_base.problem3;

public class Solution {
    // 更改了原始数组
    // 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
    // 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
    // time: O(N), space: O(1)
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}