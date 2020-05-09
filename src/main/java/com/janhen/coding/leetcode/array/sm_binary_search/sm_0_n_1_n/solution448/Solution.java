package com.janhen.coding.leetcode.array.sm_binary_search.sm_0_n_1_n.solution448;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++)
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);

        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != i + 1)        // nums[i] is redundant
                ret.add(i + 1);          // disappear, not in slot
        return ret;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}