package com.janhen.coding.leetcode.hashtable.solution349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2_my {

  // double set
  // 利用 set 自动去重性质
  // time : O(n), space:O(n)
  public int[] intersection(int[] nums1, int[] nums2) {
    // aux structure to Eliminate unnecessary results
    Set<Integer> record = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> resSet = new HashSet<>();

    for (int num : nums2)
      if (record.contains(num))
        resSet.add(num);
    return resSet.stream().mapToInt(Integer::valueOf).toArray();
  }
}
