package com.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution645;

import java.util.Arrays;

/**
 * 15 ms, faster than 48.45%
 * O(nlogn), O(1)
 */
class SolutionRef {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, dup = -1, res = nums[n-1] ^ n;
        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]){
                dup = nums[i];
            }
            res ^= i;
            res ^= nums[i-1];
        }
        res ^= dup;
        return new int[]{dup,res};
    }
}