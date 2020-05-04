package main.java.janhen.leetcode.top100.other.solution139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionMemo {


    // 7 ms, faster than 71.05%
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(s, wordSet, 0, memo);
    }

    private boolean wordBreak(String s, Set<String> wordSet, int first, Boolean[] memo) {
        if (first == s.length()) {
            return true;
        }
        if (memo[first] != null)
            return memo[first];
        for (int i = first+1; i <= s.length(); i ++) {
            String cur = s.substring(first, i);
            if (!wordSet.contains(cur)) continue;
            if (wordBreak(s, wordSet, i, memo)) {   // 判断 [i, len-1] 是否可分, [first,i-1] 已经确定可分
                memo[first] = true;
                return true;
            }
        }
        memo[first] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionMemo()).wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println((new SolutionMemo()).wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

}