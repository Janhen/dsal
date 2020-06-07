package com.janhen.coding.leetcode.string.slidingwindow.solution3;

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> freqs = new HashMap<>();
    int res = 0;

    int counter = 0;  // check whether match the target string.
    int L = 0, R = 0;
    while (R < s.length()) {
      // > 0 means repeating character
      //if(map[s.charAt(end++)]-- > 0) counter++;
      char rCh = s.charAt(R);
      R++;

      freqs.put(rCh, freqs.getOrDefault(rCh, 0) + 1);

      if (freqs.get(rCh) > 1)
        counter++;

      while (counter > 0) {
        //if (map[s.charAt(begin++)]-- > 1) counter--;
        char lCh = s.charAt(L);
        L++;

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
