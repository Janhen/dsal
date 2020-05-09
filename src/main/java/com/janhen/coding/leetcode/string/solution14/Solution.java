package com.janhen.coding.leetcode.string.solution14;

// 14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/
// easy

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

import com.janhen.TestUtil;

import java.util.Arrays;

class Solution {

    // 7 ms, faster than 58.51%
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] chs1 = strs[0].toCharArray();
        char[] chs2 = strs[strs.length-1].toCharArray();
        for (int i = 0; i < chs1.length; i ++ ) {
            if (i < chs2.length && chs1[i] == chs2[i])
                sb.append(chs1[i]);
            else
                return sb.toString();
        }
        return sb.toString();   // prefix is all same, prefix if chs1
    }

    public static void main(String[] args) {
        String[] strs = {"flag", "fl", "fla"};
        Arrays.sort(strs);
        TestUtil.printArr(strs);
    }
}