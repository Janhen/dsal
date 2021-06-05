package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution3;

class SolutionG {
    // sliding window that not have duplication element
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int L = 0, R = -1;
        int[] freqs = new int[256];
        while (L < s.length()) {
            if (R + 1 < s.length() && freqs[s.charAt(R + 1)] == 0) {
                freqs[s.charAt(++R)]++;
            } else {
                freqs[s.charAt(L++)]--;
            }
            res = Math.max(res, R - L + 1);
        }
        return res;
    }
}