package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution1 {
  // 获取最大频次以及为最大频次的元素个数
  public int leastInterval(char[] tasks, int n) {
    // 1. init frequency
    Map<Character, Integer> freqs = new HashMap<>();
    for (int i = 0; i < tasks.length; i++)
      freqs.put(tasks[i], freqs.getOrDefault(tasks[i], 0) + 1);

    // 2. sort map by entry    frequency reversed order, character positive order
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(((o1, o2) -> o1.getValue() != o2.getValue() ?
      Integer.compare(o2.getValue(), o1.getValue()) : Integer.compare(o1.getKey(), o2.getKey())));
    pq.addAll(freqs.entrySet());

    // 3. get max frequency count
    int maxFreqCnt = 0;
    int maxFreq = pq.peek().getValue();
    while (!pq.isEmpty() && pq.peek().getValue() == maxFreq) {
      pq.poll();
      maxFreqCnt++;
    }

    // 4. return value
    return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxFreqCnt);
  }

  public static void main(String[] args) {
    int[] ints = new int[]{1, 2, 3};
    (new Solution1()).leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
  }
}
