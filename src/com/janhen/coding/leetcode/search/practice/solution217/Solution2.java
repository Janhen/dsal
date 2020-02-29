package com.janhen.leetcode.search.practice.solution217;

// 217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1])
                return true;
        return false;
    }
}