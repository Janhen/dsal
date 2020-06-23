package com.janhen.coding.leetcode.ds.string.solution409;

// 409. Longest Palindrome
//https://leetcode.com/problems/longest-palindrome/description/

/*
计算一组字符集合可以组成的回文字符串的最大长度
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.*/

public class Solution {
 
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray())
            cnts[c] ++;

        int maxLen = 0;
        for (int cnt : cnts)
            maxLen += (cnt / 2) * 2;    // select even
        if (maxLen < s.length())
            maxLen ++;
        return maxLen;
    }
}
