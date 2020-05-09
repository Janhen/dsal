package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution581;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] aux = nums.clone();
        Arrays.sort(aux);                             // aux record ordered array
        int start = 0;
        while (start < nums.length && nums[start] == aux[start]) start ++;   // find first not correct index From left to right
        int end = nums.length-1;
        while (end > start && nums[end] == aux[end]) end --;      // find first not in correct position index From right to left
        return end - start + 1;
    }
}