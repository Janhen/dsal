package main.java.janhen.leetcode.top100.other.solution438;

// 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Easy
// hash table

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionCom {

    // 37 ms, faster than 30.72%
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        Map<Character, Integer> freqs = new HashMap<>();
        for (char c : p.toCharArray())
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        int L = 0, R = 0;
        int counter = freqs.size();
        while (R < s.length()) {
            char rCh = s.charAt(R);
            if (freqs.containsKey(rCh)) {
                freqs.put(rCh, freqs.get(rCh) - 1);   // [R] in match
                if (freqs.get(rCh) == 0) counter --;   // [R] all match
            }
            R ++;
            while (counter == 0) {  // [L, R] have all match
                char lCh = s.charAt(L);
                if (freqs.containsKey(lCh)) {  // [L] in match, reset to
                    freqs.put(lCh, freqs.get(lCh) + 1);
                    if (freqs.get(lCh) > 0) counter ++;     // [L, R] lack [L]
                }
                if (R - L == p.length())
                    res.add(L);
                L ++;
            }
        }
        return res;
    }
}