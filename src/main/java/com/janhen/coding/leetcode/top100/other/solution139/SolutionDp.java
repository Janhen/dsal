package main.java.janhen.leetcode.top100.other.solution139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 6 ms, faster than 84.07%
class SolutionDp {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i ++) { // [0,0], [0,1], [0,2]... [0,len-1]
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {      /* 找到之前可分割的, 再判断剩下的字符是否在字典中 */
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println((new SolutionDp()).wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println((new SolutionDp()).wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

}