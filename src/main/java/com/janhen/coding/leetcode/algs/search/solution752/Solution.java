package com.janhen.coding.leetcode.algs.search.solution752;/// Leetcode 752

import java.util.*;

import static java.util.stream.Collectors.toSet;

class Solution {
  public int openLock(String[] deadends, String target) {
    Set<String> deadset = Arrays.stream(deadends).collect(toSet());

    if (deadset.contains(target)) return -1;
    if (deadset.contains("0000")) return -1;
    if (target.equals("0000")) return 0;

    // BFS
    Queue<String> queue = new LinkedList<>();
    // map to record status
    HashMap<String, Integer> visited = new HashMap<>();
    queue.add("0000");
    visited.put("0000", 0);
    while (!queue.isEmpty()) {
      String curs = queue.remove();
      char[] curarray = curs.toCharArray();

      ArrayList<String> nexts = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
        char o = curarray[i];
        curarray[i] = Character.forDigit((curarray[i] - '0' + 1) % 10, 10);
        nexts.add(new String(curarray));
        curarray[i] = o;

        curarray[i] = Character.forDigit((curarray[i] - '0' + 9) % 10, 10);
        nexts.add(new String(curarray));
        curarray[i] = o;
      }

      for (String next : nexts)
        if (!deadset.contains(next) && !visited.containsKey(next)) {
          queue.add(next);
          visited.put(next, visited.get(curs) + 1);
          if (next.equals(target)) return visited.get(next);
        }
    }

    return -1;
  }
}
