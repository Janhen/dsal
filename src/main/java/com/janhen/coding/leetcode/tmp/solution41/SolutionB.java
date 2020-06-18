package com.janhen.coding.leetcode.tmp.solution41;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SolutionB {
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) {
      return 1;
    }

    List<Integer> record = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    for (int i = 1; i <= nums.length + 1; i++) {
      if (record.contains(i)) {
        continue;
      }
      return i;
    }
    return 0;
  }
}