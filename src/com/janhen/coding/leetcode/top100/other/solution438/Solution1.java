package com.janhen.leetcode.top100.other.solution438;

import java.util.ArrayList;
import java.util.List;

class Solution1 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] freqs = new int[256];
        for (char val : p.toCharArray())
            freqs[val] ++;
        int L = 0, R = 0;
        int counter = p.length();
        while (R < p.length()) {
            if (-- freqs[s.charAt(R ++)] >= 0)
                counter --;
        }
        if (counter == 0)
            res.add(0);
        while (R < s.length()) {
            if (freqs[s.charAt(L ++)] ++ >= 0)  // slide one step
                counter ++;
            if (-- freqs[s.charAt(R ++)] >= 0)
                counter --;
            if (counter == 0) res.add(L);
        }
        return res;
    }
}