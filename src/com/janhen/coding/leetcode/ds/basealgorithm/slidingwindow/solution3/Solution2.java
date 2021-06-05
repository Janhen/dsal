package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution3;

import java.util.Arrays;

class Solution2 {
    // current iterate element can be three logic position
    public int lengthOfLongestSubstring(String s) {
        int[] preIndex = new int[256];
        Arrays.fill(preIndex, -1);
        int curWinLen = 0, maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (preIndex[s.charAt(i)] == -1 || i - preIndex[s.charAt(i)] > curWinLen) {
                curWinLen++;
            } else {
                curWinLen = i - preIndex[s.charAt(i)];
            }
            preIndex[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, curWinLen);
        }
        return maxLen;
    }
}
