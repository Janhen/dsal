package com.janhen.coding.leetcode.ds.hashtable.practice.solution205;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    // error    ab  aa                  ab -> aa ✔, aa -> ab ✘
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> preIndexOfS = new HashMap<>();   // s -> t
        Map<Character, Integer> preIndexOfT = new HashMap<>();   // t -> s
        for (int i = 0; i < s.length(); i++) {                             // last seen positions
            if (preIndexOfS.put(s.charAt(i), i) != preIndexOfT.put(t.charAt(i), i))
                return false;
        }
        return true;
    }
}