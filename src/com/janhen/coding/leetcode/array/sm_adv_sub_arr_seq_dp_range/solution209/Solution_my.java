package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution209;

public class Solution_my {

    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;     // record result
        int L = 0, R = -1;
        int winSum = 0;
        while (L < nums.length) {
            if (R + 1 < nums.length && winSum < s) {
                winSum += nums[R + 1];
                R ++;   // [R] in window
            } else {
                winSum -= nums[L];
                L ++;                  // sliding window only can move right
            }
            if (winSum >= s) {
                minLen = Math.min(minLen, R - L + 1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;           // need handle init value
    }
}
