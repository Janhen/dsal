package com.janhen.coding.leetcode.algs.sort.solution347;

import java.util.*;

public class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0) + 1);
    // map to sort nums freq by storage additional attribute
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
    for (Integer key : map.keySet()) {
      pq.offer(key);
      if (pq.size() == k + 1)
        pq.poll();
    }
    return pq.stream().mapToInt(Integer::valueOf).toArray();
  }
}
