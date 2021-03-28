package com.janhen.coding.leetcode.algs.math.solution628;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution$ {
  // time: O(n), space: O(1)
  public int maximumProduct(int[] nums) {
    PriorityQueue<Integer> poheap = new PriorityQueue<>();
    PriorityQueue<Integer> neheap = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
      poheap.offer(num);
      neheap.offer(num);
      if (poheap.size() > 3) {
        poheap.poll();
      }
      if (neheap.size() > 2) {
        neheap.poll();
      }
    }
    int c1 = 1;
    int max = 0;
    while (!poheap.isEmpty()) {
      max = poheap.poll();
      c1 *= max;
    }
    while (!neheap.isEmpty()) {
      max *= neheap.poll();
    }
    return Math.max(c1, max);
  }
}