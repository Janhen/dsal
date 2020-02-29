package com.janhen.leetcode.top100.other.solution139;

import java.util.Arrays;
import java.util.List;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }

    private boolean wordBreak(String s, List<String> wordDict, int first) {
        if (first == s.length()) {
            return true;
        }
        for (int i = first + 1; i <= s.length(); i++) {
            String cur = s.substring(first, i);
            if (!wordDict.contains(cur)) // loop
                continue;
            if (wordBreak(s, wordDict, i))    // 判断 [i, len-1] 是否可分, [first,i-1] 已经确定可分
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println((new Solution()).wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}