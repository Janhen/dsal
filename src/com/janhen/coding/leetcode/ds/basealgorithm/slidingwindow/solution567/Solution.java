package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution567;

public class Solution {

  public boolean checkInclusion(String s1, String s2) {
    int L = 0, R = 0;
    int[] freqs = new int[256];
    for (char val : s1.toCharArray())
      freqs[val]++;

    int counter = s1.length();
    while (R < s2.length()) {
      char rCh = s2.charAt(R);
      R++;

      // rCh in s1
      if (--freqs[rCh] >= 0) {
        counter--;
      }

      if (counter == 0) {
        return true;
      }

      // fixed window to shrink
      if (R - L == s1.length()) {
        char lCh = s2.charAt(L);
        L++;

        // lCh in s1
        if (freqs[lCh]++ >= 0) {
          counter++;
        }
      }
    }
    return false;
  }
}
