package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution560;

public class SolutionError {
    public int subarraySum(int[] nums, int k) {     //
        int count = 0;
        int L = 0, R = -1;
        int winSum = 0;
        while (L < nums.length) {
            if (R + 1 < nums.length && winSum < k) {
                winSum += nums[++ R];
            } else {
                winSum -= nums[L ++];
            }
            if (winSum == k) {
                count ++;
            }
        }
        return count;
    }
}
