package com.janhen.coding.leetcode.ds.array.solution442;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //  nums[i]      x
    //    i         x-1
    // x=nums[i]
    // nums[x-1]=x   =>   nums[nums[i] - 1] = nums[i]
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 1. put element in should position
        for (int i = 0; i < nums.length; i++) {
            // not in element should put position
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 2. find all not should position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}