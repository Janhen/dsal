package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution10;

public class Solution {
    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null)
            return false;
        return isMatch(str.toCharArray(), 0, str.length(), pattern.toCharArray(), 0, pattern.length());
    }

    private boolean isMatch(char[] str, int i, int len1, char[] pattern, int j, int len2) {
        if (i == len1 && j == len2)
            return true;
        // "",".*"
        if (i != len1 && j == len2)
            return false;

        if (j + 1 < len2 && pattern[j + 1] == '*') {
            if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                return isMatch(str, i, len1, pattern, j + 2, len2)
                        || isMatch(str, i + 1, len1, pattern, j, len2)
                        || isMatch(str, i + 1, len1, pattern,j + 2, len2);
            }
            // "",".*"
            return isMatch(str, i, len1, pattern, j + 2, len2);
        }
        if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
            return isMatch(str, i + 1, len1, pattern, j + 1, len2);
        }
        return false;
    }
}
