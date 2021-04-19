package com.janhen.coding.leetcode.ds.hashtable.solution220;

//220. Contains Duplicate III
//        https://leetcode.com/problems/contains-duplicate-iii/description/
// medium
// sliding window

// Given an array of integers, find out whether there are two distinct
// indices i and j in the array such that the absolute difference
// between nums[i] and nums[j] is 【at most】 t and the absolute difference between i and j is 【at most】 k.
//
//Example 1:
//
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
//Example 2:
//
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
//Example 3:
//
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false

// 在 k 索引范围内两数是否有小于等于 t


import java.util.TreeSet;

class Solution2 {
    // @Error: integer overflow
    // ordered data structure as sliding window
    // time : O(nlogn)
    // space : O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // ∃x, nums[i]-t <= x <= nums[i]+t
        // ⇒ ∃x, x>=nums[i]-t     ⇔  record.ceiling(nums[i]-t)!=null
        //    ∃x, x<=nums[i]+t     ⇔  record.ceiling(nums[i]-t)<=nums[i]+t

        TreeSet<Integer> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.ceiling(nums[i] - t) != null &&                   // have first element that >= nums[i]-t
              // and this first element <= nums[i]+t
              record.ceiling(nums[i] - t) <= nums[i] + t)  // ∃x, nums[i]-t <= x <= nums[i]+t   in set.
                return true;
            record.add(nums[i]);
            if (record.size() == k + 1)
                record.remove(nums[i - k]);
        }
        return false;
    }

    // 整形溢出问题  (1,2133333...)    nums[i] + t
}