package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution169;

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {    // reset majority AND count
                count = 1;
                candidate = num;
                continue;
            }
            count = num == candidate ? ++ count : -- count;
        }
        return candidate;
    }
}