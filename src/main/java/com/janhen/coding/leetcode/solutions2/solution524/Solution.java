package main.java.janhen.leetcode.solutions2.solution524;

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

import java.util.Collections;
import java.util.List;

//  67 ms, faster than 20.59%
class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (s1, s2) -> {
            int lenDiff = s2.length()-s1.length();
            if (lenDiff != 0)
                return lenDiff;
            return s1.compareTo(s2);
        });
        for (String str : d) {
            if (isValid(s, str)) {
                return str;
            }
        }
        return "";
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