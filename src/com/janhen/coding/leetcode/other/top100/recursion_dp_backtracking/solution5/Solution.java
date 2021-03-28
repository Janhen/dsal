package com.janhen.coding.leetcode.other.top100.recursion_dp_backtracking.solution5;

class Solution {
    private int maxLen;
    private int fromIdx;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i ++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(fromIdx, fromIdx + maxLen);
    }

    private void extend(String str, int i, int j) {
        while (i >=0 && j < str.length()
          && str.charAt(i) == str.charAt(j)) {
            i --;
            j ++;
        }
        // find not meet ...
        if (maxLen < j - i - 1) {
            fromIdx = i + 1;
            maxLen = j - i - 1;
        }
    }
}