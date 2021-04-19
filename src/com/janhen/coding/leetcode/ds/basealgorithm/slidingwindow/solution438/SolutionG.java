package com.janhen.coding.leetcode.ds.basealgorithm.slidingwindow.solution438;

import java.util.ArrayList;
import java.util.List;

class SolutionG {
    // fixed window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int L = 0, R = 0;
        int[] freqs = new int[256];
        for (char val : p.toCharArray())
            freqs[val]++;

        int counter = p.length();
        while (R < s.length()) {
            if (--freqs[s.charAt(R++)] >= 0)
                counter--;
            if (counter == 0)
                res.add(L);
            if (R - L == p.length()) {   // fixed size AND narrow window
                if (freqs[s.charAt(L++)]++ >= 0)
                    counter++;
            }
        }
        return res;
    }
}