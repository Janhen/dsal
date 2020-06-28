package com.janhen.coding.leetcode.ds.array.sm_adv_sub_arr_seq_dp_range.solution621;

import java.util.*;

/*
 * 99 ms, faster than 16.88%
 * https://leetcode.com/problems/task-scheduler/discuss/104501/Java-PriorityQueue-solution-Similar-problem-Rearrange-string-K-distance-apart
 *
 * The idea used here is similar to - https://leetcode.com/problems/rearrange-string-k-distance-apart
We need to arrange the characters in string such that each same character is K distance apart, where distance in this problems is time b/w two similar task execution.

Idea is to add them to a priority Q and sort based on the highest frequency.
And pick the task in each round of 'n' with highest frequency. As you pick the task, decrease the frequency, and put them back after the round.
 */
class SolutionRef {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < tasks.length; i++)
      freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);

    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(            // frequency sort
      (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
    pq.addAll(freq.entrySet());

    int count = 0;
    while (!pq.isEmpty()) {
      int k = n + 1;
      List<Map.Entry> tempList = new ArrayList<>();
      while (k > 0 && !pq.isEmpty()) {
        Map.Entry<Character, Integer> top = pq.poll(); // most frequency task
        top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
        tempList.add(top); // collect task to add back to queue
        k--;
        count++; //successfully executed task
      }

      for (Map.Entry<Character, Integer> e : tempList) {
        if (e.getValue() > 0) pq.add(e); // add valid tasks
      }

      if (pq.isEmpty()) break;
      count = count + k; // if k > 0, then it means we need to be idle
    }
    return count;
  }
}
