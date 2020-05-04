package main.java.janhen.leetcode.search.solution220;

import java.util.TreeSet;

class Solution1_ {
    // can handler integer overflow
    // 24 ms, faster than 64.03%
    // time : O(nlogn)
    // space : O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            final Long floor = record.floor((long)nums[i] + (long)t);
            final Long ceil = record.ceiling((long)nums[i] - (long)t);
            if ((floor != null && floor >= (long)nums[i]) || (ceil != null && ceil <= (long)nums[i]))
                return true;
            record.add((long) nums[i]);
            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }
        return false;
    }
 }