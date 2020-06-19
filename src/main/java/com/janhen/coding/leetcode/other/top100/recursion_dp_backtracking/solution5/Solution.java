package com.janhen.coding.leetcode.other.top100.recursion_dp_backtracking.solution5;

class Solution {
    private int fromIndex;

    private int maxLen;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i ++) {                // len-2 terminal
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(fromIndex, fromIndex + maxLen);
    }

    private void extend(String str, int i , int j) {    // in this function [i,j] may not valid palindrome
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {   // find first not palindrome
            i --;
            j ++;
        }
        if (maxLen < (j-i-1)) {     // now [i] != [j], [i+1] == [j-1]  ⇒ palindrome length = j-i-1
            fromIndex = i + 1;
            maxLen = j - i - 1;
        }
    }
}