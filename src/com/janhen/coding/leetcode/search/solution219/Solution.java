package com.janhen.leetcode.search.solution219;

import java.util.HashSet;
import java.util.Set;

//219. Contains Duplicate II
//        https://leetcode.com/problems/contains-duplicate-ii/description/
// easy
// 数组中在 k 范围差内是否有相同的数

// Given an array of integers and an integer k,
// find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
// and the absolute difference between i and j is at most k.

//Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true
//Example 2:
//Input: nums = [1,0,1,1], k = 1
//Output: true
//Example 3:
//Input: nums = [1,2,3,1,2,3], k = 2
//Output: false

class Solution {

    // the sliding window , use set as
    // 9 ms, faster than 91.34%
    // time : O(N)
    // space : O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return false;
        if (k <= 0)
            return false;

        Set<Integer> record = new HashSet<>();  // fixed capacity k
        for (int i = 0; i < nums.length; i ++) {
            if (record.contains(nums[i]))  // ∃x, x==nums[i]
                return true;
            record.add(nums[i]);  // init and strategy
            if (record.size() == k + 1) // fixed capacity
                record.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
//        int[] nums = {1,0,1,1};

        boolean res = (new Solution()).containsNearbyDuplicate(nums, 2);
        System.out.println(res);
    }
}