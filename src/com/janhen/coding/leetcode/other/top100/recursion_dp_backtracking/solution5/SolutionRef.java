package com.janhen.coding.leetcode.other.top100.recursion_dp_backtracking.solution5;

public class SolutionRef {

    // 13 ms, faster than 82.06%
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLen = 0;
        int fromIndex = 0;  
        int i = 0;
        int len = s.length();
        while (i < s.length()) {
            int l = i;
            int r = i;
            //find the middle of a palindrome,   handle from [i] extend or [i],[i+1] extend to same way
            while (r < len - 1 && s.charAt(r) == s.charAt(r + 1)) r++;
            i = r + 1;                          // this time, [l, r] is all same
            //expand from the middle out
            while (r < len - 1 && l > 0 && s.charAt(r + 1) == s.charAt(l - 1)) {
                r++;
                l--;
            }
            // [l,r] is palindrome
            if (r - l + 1 > maxLen) {
                fromIndex = l;
                maxLen = r - l + 1;
            }
        }
        return s.substring(fromIndex, fromIndex + maxLen);
    }
}