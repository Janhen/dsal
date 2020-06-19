package com.janhen.coding.leetcode.other.solutions2.solution524;

// 524. Longest Word in Dictionary through Deleting
//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/

/*

Medium

285

160

Favorite

Share
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output:
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output:
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.
 */

import java.util.List;

// 35 ms, faster than 56.20%
class Solution2 {
    // 不排序
    public String findLongestWord(String s, List<String> d) {
        String curStr = "";
        int curLen = -1;
        for (String m : d) {
            int mLen = m.length();
            if (curLen > mLen)                               // len
                continue;
            if (curLen == mLen && curStr.compareTo(m) < 0)   // dictionary sequence
                continue;
            if (isValid(s, m)) {
                curLen = m.length();
                curStr = m;
            }
        }
        return curStr;
    }

    // 正向序列下 str 是否可组合成 match
    private boolean isValid(String str, String match) {
        int i = 0, j = 0;
        while (i < str.length() && j < match.length()) {
            if (str.charAt(i) == match.charAt(j))
                j ++;
            i ++;
        }
        return j == match.length();
    }
}