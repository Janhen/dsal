package com.janhen.coding.leetcode.string.slidingwindow.solution438;

import java.util.ArrayList;
import java.util.List;

class Solution {
  // fixed window
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();

    int L = 0, R = 0;
    int[] freqs = new int[256];
    for (char val : p.toCharArray())
      freqs[val]++;

    int counter = p.length();
    while (R < s.length()) {
      // right move element, and window move
      char rCh = s.charAt(R);
      R++;

      // sliding window element update
      if (--freqs[rCh] >= 0)
        counter--;

      // collect result
      if (counter == 0)
        res.add(L);

      // shrink left edge window
      if (R - L == p.length()) {   // fixed size AND narrow window
        // get left element and sliding window shrink
        char lCh = s.charAt(L);
        L++;

        if (freqs[lCh]++ >= 0)
          counter++;
      }
    }
    return res;
  }
}