package com.janhen.coding.leetcode.ds.hashtable.practice.solution217;

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