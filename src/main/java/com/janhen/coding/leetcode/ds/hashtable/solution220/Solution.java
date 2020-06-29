package com.janhen.coding.leetcode.ds.hashtable.solution220;

import java.util.TreeSet;

class Solution {
  // can handler integer overflow
  // time : O(nlogn), space : O(k)
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    final TreeSet<Long> record = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      //      [i]-t ... [i] ... [i]+t
      // 1. find floor and ceil meet condition value
      final Long floor = record.floor((long) nums[i] + (long) t);
      final Long ceil = record.ceiling((long) nums[i] - (long) t);
      // 2. judge floor and ceil result
      if ((floor != null && floor >= (long) nums[i])
        || (ceil != null && ceil <= (long) nums[i]))
        return true;
      record.add((long) nums[i]);
      // 3. keep coll size
      if (record.size() == k + 1)
        record.remove((long) nums[i - k]);
    }
    return false;
  }
}