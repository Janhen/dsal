package com.janhen.coding.leetcode.array.sm_base_two_search_sort_matrix.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {     // must have 3
            if (i > 0 && nums[i] == nums[i -1]) continue;    // skip duplication
            // as sub problem to solve
            int l = i + 1, r = nums.length - 1;          // [i+1,len) to find [l]+[r] = 0-[i], 同时避免重复元素
            while (l < r) {
                if (l != i + 1 && nums[l] == nums[l-1]) {            // to skip duplication from left to right
                    l ++;
                    continue;
                }
                if (r != nums.length - 1 && nums[r] == nums[r+1]) {    // to skip duplication from right to left
                    r --;
                    continue;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[l ++], nums[r --]));     // to be continue
                else if (sum > 0)
                    r --;
                else
                    l ++;
            }
        }
        return res;
    }
}