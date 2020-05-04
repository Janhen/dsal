package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution169;

import java.util.Arrays;

class Solution_sort {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}