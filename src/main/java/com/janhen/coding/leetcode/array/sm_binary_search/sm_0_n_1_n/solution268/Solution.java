package com.janhen.coding.leetcode.array.sm_binary_search.sm_0_n_1_n.solution268;

class Solution {

    // 题目描述：数组元素在 0-n 之间，但是有一个数是缺失的，要求找到这个缺失的数。
    // A ^ A = 0
    // 0 1 2 3 4 5 6    7 6 3 4 5 2    ...
    // 手动构造重复的对 ^0-n
    //                ^[0]-[n-1]
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            res ^= i;                  // [0,n-1]
            res ^= nums[i];            // [0,n]
        }
        res ^= nums.length;
        return res;
    }
}