package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution209;

class Solution {

    // l, r 不断增大
    // l=N,r=N-1 over
    // dynamic adjust
    // time:O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;             // 0 can collect
        int sum = 0;              // sliding window attribute
        int L = 0, R = -1;        // find max sliding window size
        while (L < nums.length) {
            // handle sliding window size
            if (R  < nums.length - 1 && sum < s)
                sum += nums[++ R];    // expand window, put [R] in
            else
                sum -= nums[L ++];    // narrow window, take [L] out

            // current sliding window meet the conditions
            if (sum >= s)
                minLen = Math.min(minLen, R - L + 1);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
