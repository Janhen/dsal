package com.janhen.coding.leetcode.ds.hashtable.solution350;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  // TODO Follow
  // two list add + remove
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> record = new ArrayList<>(); // every element record
    List<Integer> ret = new ArrayList<>();
    for (int num : nums1) // init record list
      record.add(num);

    for (int num : nums2) { // ∃, remove
      if (record.contains(num)) {
        ret.add(num);
        record.remove(Integer.valueOf(num)); // convert to value to remove
      }
    }
    return ret.stream().mapToInt(Integer::valueOf).toArray();
  }
}
