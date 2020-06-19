package com.janhen.coding.leetcode.math.solution169;

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {    // reset majority and count
                count = 1;
                candidate = num;
                continue;
            }
            count = num == candidate ? ++ count : -- count;
        }
        return candidate;
    }
}