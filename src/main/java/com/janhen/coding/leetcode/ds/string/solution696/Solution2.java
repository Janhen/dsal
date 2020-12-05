package com.janhen.coding.leetcode.ds.string.solution696;

import java.util.ArrayList;
import java.util.List;

/*
 * 0001100
 *   01           preLen:3,curLen=1
 *  0011          preLen:3,curLen=2
 *     10         preLen:2,curLen=1
 *    1100        preLen:2,curLen=2
 */
class Solution2 {
  public int countBinarySubstrings(String s) {
    List<Integer> counts = new ArrayList<>();
    int k = 0;
    int len = s.length();
    while (k < len) {
      char c = s.charAt(k);
      int count = 0;
      while (k < len && s.charAt(k) == c) {
        ++k;
        ++count;
      }
      counts.add(count);
    }
    int ans = 0;
    for (int i = 1; i < counts.size(); ++i) {
      ans += Math.min(counts.get(i), counts.get(i - 1));
    }
    return ans;
  }
}