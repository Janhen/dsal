package com.janhen.coding.leetcode.algs.sort.solution451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public String frequencySort(String s) {
    // 1. frequency statistics
    Map<Character, Integer> freqs = new HashMap<>();
    for (char c : s.toCharArray())
      freqs.put(c, freqs.getOrDefault(c, 0) + 1);

    // 2. heap to sort by frequency
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    pq.addAll(freqs.entrySet());

    // 3. build result
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry e = pq.poll();
      for (int i = 0; i < (int)e.getValue(); i++)
        sb.append(e.getKey());
    }
    return sb.toString();
  }
}
