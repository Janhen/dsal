package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution3;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> freqs = new HashMap<>();
    int res = 0;

    int counter = 0;
    int L = 0, R = 0;
    while (R < s.length()) {
      // add right char
      char rCh = s.charAt(R ++);
      freqs.put(rCh, freqs.getOrDefault(rCh, 0) + 1);
      if (freqs.get(rCh) > 1)
        counter++;

      while (counter > 0) {
        // eliminate left char
        char lCh = s.charAt(L ++);
        if (freqs.get(lCh) > 1)
          counter--;
        freqs.put(lCh, freqs.get(lCh) - 1);
      }

      // find one window
      res = Math.max(res, R - L);
    }
    return res;
  }
}
