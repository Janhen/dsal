package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
  public int leastInterval(char[] tasks, int n) {
    // collect freqs
    Map<Character, Integer> freqs = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) {
      freqs.put(tasks[i], freqs.getOrDefault(tasks[i], 0) + 1);
    }

    // sort by freq and char
    freqs = freqs.entrySet().stream().sorted(Comparator.<Map.Entry<Character, Integer>>comparingInt(e -> e.getValue()).reversed()
      .thenComparing(e -> e.getKey()))
      .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (o, ne) -> o, LinkedHashMap::new));

    // find maxFreq entry count
    int maxFreq = freqs.entrySet().iterator().next().getValue();
    int count = (int) freqs.entrySet().stream().filter(e -> e.getValue() == maxFreq).count();

    // collect result
    return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + count);
  }
}
