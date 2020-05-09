package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution152;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[n-1];
        int max = nums[n-1], min = nums[n-1];
        for (int i = n-2; i >= 0; i --) {
            if (nums[i] < 0) {    // handle max min not meet because [i] is negative
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(nums[i], max * nums[i]);    // 子数组  ⇒ max{[i],max*[i]},  子序列  ⇒  max{max,max*[i]}
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}