package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution128;

import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class Solution {
  public int longestConsecutive(int[] nums) {
    int max = 0;
    // copy and duplicate removal
    Set<Integer> set = IntStream.of(nums).boxed().collect(toSet());

    for (int num : nums) {
      int cnt = 1;

      // delete from left to right
      int curNum = num;
      while (set.contains(++curNum)) {
        cnt++;
        set.remove(curNum);
      }

      // delete from right to left
      curNum = num;
      while (set.contains(--curNum)) {
        cnt++;
        set.remove(curNum);
      }

      // compare num continue and collect result
      max = Math.max(max, cnt);
    }
    return max;
  }
}
