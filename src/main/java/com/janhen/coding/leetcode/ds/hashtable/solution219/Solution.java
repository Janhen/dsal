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

    // duplicate removal and fixed capacity k
    Set<Integer> record = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (record.contains(nums[i])) // ∃x, x==nums[i], duplicate
        return true;
      record.add(nums[i]);         // init and strategy
      if (record.size() == k + 1)  // fixed capacity
        record.remove(nums[i - k]);
    }
    return false;
  }
}