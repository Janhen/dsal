package com.janhen.coding.leetcode.ds.bit.solution136;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}