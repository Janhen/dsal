package main.java.janhen.leetcode.top100.other.solution139;

// 139. Word Break
//https://leetcode.com/problems/word-break/

/*

Medium

1797

104

Favorite

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionREF {

    public boolean wordBreak(String s, List<String> wordDict) {
        // create the memoization array to save results and avoid repeat computations
        Boolean[] canBreak = new Boolean[s.length()];

        // convert the list into set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // recursion with memoization
        return helper(s, 0, wordSet, canBreak);
    }

    //  __ __ __ __ __ __ __ __ __
    //               _____________


    //       _____________________
    //       _
    //       __
    //       ___
    //       ____
    //       _____
    //       ______
    private boolean helper(String s, int startIdx, Set<String> wordSet, Boolean[] canBreak) {
        // in case we've reached the end of string, return true
        if (startIdx == s.length()) return true;
        // else if we've already computed on current substring before
        if (canBreak[startIdx] != null) return canBreak[startIdx]; // auto-unboxing

        boolean res = false;
        // iterate through all indices after startIdx, explore every possible word
        for (int i = startIdx + 1; i <= s.length(); i++) {
            String currWord = s.substring(startIdx, i);
            // skip if this is not a word in the input dictionary
            if (!wordSet.contains(currWord)) continue;
            // recursively call upon the rest of string
            if (helper(s, i, wordSet, canBreak)) {
                res = true;
                break;
            }
        }
        // add result to memo and return the result
        canBreak[startIdx] = res;
        return res;
    }
}