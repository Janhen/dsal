package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution80;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int k = 0;
        for (int num : nums)
            if (k < 2 || num > nums[k - 2])  // not repeat
                // current nums element  ..
                nums[k ++] = num;
        return k;
    }
}