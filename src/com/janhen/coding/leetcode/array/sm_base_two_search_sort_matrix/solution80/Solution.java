package com.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution80;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int k = 1;                 // from first begin, [0] = [0]
        int count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[i-1]) {
                nums[k ++] = nums[i];
                count = 1;
            } else {                    // excepted
                if (count < 2)
                    nums[k ++] = nums[i];
                count ++;
            }
        }
        return k;
    }
}