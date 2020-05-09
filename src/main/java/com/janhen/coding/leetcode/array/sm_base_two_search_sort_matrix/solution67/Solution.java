package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution67;

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {   // use array to express num, [n-1] is bit
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums =  new int[digits.length+1];      // need carry
        nums[0] = 1;
        return nums;
    }
}