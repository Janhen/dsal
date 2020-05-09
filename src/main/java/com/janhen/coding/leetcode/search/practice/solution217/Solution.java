package com.janhen.coding.leetcode.search.practice.solution217;

// 217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/
// easy

/*
判断数组是否含有重复元素

Input: [1,2,3,1]
Output: true

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }
}