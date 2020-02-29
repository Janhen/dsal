package com.janhen.leetcode.search.solution219;

//219. Contains Duplicate II
//        https://leetcode.com/problems/contains-duplicate-ii/description/

import java.util.HashSet;
import java.util.Set;

class Solution1__ {

    // first init sliding window size then ...
    // 7 ms, faster than 98.27%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 ||
                k < 0)
            return false;

        Set<Integer> set = new HashSet<>();
        // init window size to k + 1
        for (int i = 0; i < nums.length && i <= k; i ++)   // init put k+1 elements
            if (!set.add(nums[i]))  // already include and
                return true;

        // i: for maintaining window size, need to remove
        // j: current traversal element
        for (int i = 1, j = k + 1; j < nums.length; i ++, j ++) {
            set.remove(nums[i - 1]);
            if (!set.add(nums[j]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};

        boolean res = (new Solution1__()).containsNearbyDuplicate(nums, 2);
        System.out.println(res);
    }
}