package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution67;

// 66. Plus One
// https://leetcode.com/problems/plus-one/
// Easy

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */

class Solution2 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --) {
            digits[i] += carry;
            if (digits[i] <= 9)
                return digits;
            digits[i] = 0;
        }
        int[] nums =  new int[digits.length+1];
        nums[0] = 1;
        return nums;
    }
}