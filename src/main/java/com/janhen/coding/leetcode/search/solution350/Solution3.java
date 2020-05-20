package com.janhen.coding.leetcode.search.solution350;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
  // two list add + remove
  // 9 ms, faster than 17.56%
  public int[] intersect(int[] nums1, int[] nums2) {
    List<Integer> record = new ArrayList<>(); // every element record
    List<Integer> res = new ArrayList<>();
    for (int num : nums1) // init record list
      record.add(num);

    for (int num : nums2) { // ∃, remove
      if (record.contains(num)) {
        res.add(num);
        record.remove(Integer.valueOf(num)); // convert to value to remove
      }
    }
    return res.stream().mapToInt(Integer::valueOf).toArray();
  }
}
