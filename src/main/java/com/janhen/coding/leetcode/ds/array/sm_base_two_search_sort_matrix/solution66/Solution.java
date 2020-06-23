package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution66;

class Solution {
    /*
    three condition:
    - low bit [0, 8]
    - can carry
    - can continue carry
     */
    public int[] plusOne(int[] digits) {
        // use array to express num, [n-1] is low bit
        for (int i = digits.length - 1; i >= 0; i --) {
            // terminal condition
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        // not meet fast success condition, num to carry and expand array size
        int[] nums =  new int[digits.length+1];
        nums[0] = 1;
        return nums;
    }
}