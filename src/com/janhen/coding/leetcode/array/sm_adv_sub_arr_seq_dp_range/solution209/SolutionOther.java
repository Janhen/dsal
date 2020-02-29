package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution209;

// 209. Minimum Size Subarray Sum
//         https://leetcode.com/problems/minimum-size-subarray-sum/description/
// medium

// Given an array of n 【positive integers】 and a positive integer s,
// find the minimal length of a contiguous subarray of which the 【sum ≥ s】. If there isn't one, return 0 instead.

// error
class SolutionOther {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }
        int L = 0;
        int R = 0;
        int sum = nums[0];
        int minLen = nums.length + 1;
        while (R < nums.length) {
            if (sum == s) {
                minLen = Math.min(minLen, R - L + 1);
                sum -= nums[L ++];
            } else if (sum < s) {   // < right
                R ++;
                if (R == nums.length)  // border control
                    break;
                sum += nums[R];    // right shift to add
            } else {           // x >  left
                sum -= nums[L++];
            }
        }
        return minLen;
    }
}