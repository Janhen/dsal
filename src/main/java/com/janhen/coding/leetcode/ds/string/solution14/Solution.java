package com.janhen.coding.leetcode.ds.string.solution14;

// 14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/

import com.janhen.TestUtil;

import java.util.Arrays;

class Solution {
    // 7 ms, faster than 58.51%
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        // sort original string, easy to iterate ordinal
        Arrays.sort(strs);

        // only compare first and last string
        StringBuilder builder = new StringBuilder();
        char[] chs1 = strs[0].toCharArray();
        char[] chs2 = strs[strs.length-1].toCharArray();
        for (int i = 0; i < chs1.length; i ++ ) {
            if (i < chs2.length && chs1[i] == chs2[i])
                builder.append(chs1[i]);
            else
                return builder.toString();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flag", "fl", "fla"};
        Arrays.sort(strs);
        TestUtil.printArr(strs);
    }
}