package com.janhen.coding.leetcode.algs.math.solution169;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Solution2 {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> freqs = new HashMap<>();
    for (int num : nums)
      freqs.put(num, freqs.getOrDefault(num, 0) + 1);

    Optional<Integer> first = freqs.values().stream()
      .filter(v -> v > nums.length / 2).findFirst();
    return first.orElse(-1);
  }
}