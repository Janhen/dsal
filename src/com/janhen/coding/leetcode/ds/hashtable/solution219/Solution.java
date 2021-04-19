package com.janhen.coding.leetcode.ds.hashtable.solution219;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // time : O(N),  space : O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return false;
        if (k <= 0)
            return false;

        // 维护固定大小的 Set 用于去重和范围限定
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }
}