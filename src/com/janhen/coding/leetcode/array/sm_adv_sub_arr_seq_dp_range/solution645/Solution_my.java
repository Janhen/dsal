package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution645;

public class Solution_my {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {    // put correct position, NOTE: is while condition
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i , int j) {
        int t= nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
