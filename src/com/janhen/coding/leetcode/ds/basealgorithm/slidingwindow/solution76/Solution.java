package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution76;

class Solution {
    // window size not fixed
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE, fromIndex = 0;
        int L = 0, R = 0;
        int[] freqs = new int[256];
        for (char val : t.toCharArray()) {
            freqs[val]++;
        }

        int counter = t.length();
        while (R < s.length()) {
            char rCh = s.charAt(R);
            R++;

            if (--freqs[rCh] >= 0) {
                counter--;
            }

            while (counter == 0) {
                if (R - L < minLen) {  // judge
                    minLen = R - L;
                    fromIndex = L;
                }

                char lCh = s.charAt(L);
                L++;

                if (freqs[lCh]++ >= 0)
                    counter++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(fromIndex, fromIndex + minLen);
    }
}
