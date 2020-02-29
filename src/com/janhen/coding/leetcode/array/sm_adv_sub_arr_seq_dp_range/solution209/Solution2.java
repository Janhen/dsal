package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution209;

// 209. Minimum Size Subarray Sum
//         https://leetcode.com/problems/minimum-size-subarray-sum/description/

public class Solution2 {

    // l, r 不断增大
    // dynamic adjust
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;   // [l...r] 为滑动窗口
        while (r < nums.length) {
            sum += nums[r ++];
            while (sum >= s) {
                res = Math.min(res, r - l);
                sum -= nums[l ++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
