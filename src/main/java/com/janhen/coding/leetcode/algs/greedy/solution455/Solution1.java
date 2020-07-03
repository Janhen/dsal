package com.janhen.coding.leetcode.algs.greedy.solution455;

import java.util.Arrays;

class Solution1 {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int gi = 0, si = 0;
    while (gi < g.length && si < s.length) {
      if (g[gi] <= s[si]) {
        gi++;
      }
      si++;
    }
    return gi;
  }
}
