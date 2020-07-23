package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

class Solution {
  public int longestConsecutive(int[] nums) {
    // 1. copy and duplicate removal
    int max = 0;
    Set<Integer> set = IntStream.of(nums).boxed().collect(toSet());

    for (int num : nums) {
      int cnt = 1;

      // 2. delete from left to right, from right to left
      int curNum = num;
      while (set.contains(++curNum)) {
        cnt++;
        set.remove(curNum);
      }
      curNum = num;
      while (set.contains(--curNum)) {
        cnt++;
        set.remove(curNum);
      }

      // 3. compare num continue and collect result
      max = Math.max(max, cnt);
    }
    return max;
  }
}
