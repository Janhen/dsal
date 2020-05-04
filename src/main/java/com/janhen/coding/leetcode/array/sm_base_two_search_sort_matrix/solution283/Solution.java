package main.java.janhen.leetcode.array.sm_base_two_search_sort_matrix.solution283;

class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0)
                nums[k ++] = nums[i];
        for (int i = k; i < nums.length; i ++)
            nums[i] = 0;
    }
}