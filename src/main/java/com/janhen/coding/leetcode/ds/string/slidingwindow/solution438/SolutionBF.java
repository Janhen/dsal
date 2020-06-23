package com.janhen.coding.leetcode.ds.string.slidingwindow.solution438;

import java.util.*;

class SolutionBF {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        int m = s.length(), n = p.length();
        p = sort(p);
        for (int i = 0; i < m - n + 1; i ++) {
            String key = sort(s.substring(i, i + n));
            if (key.equals(p))
                res.add(i);
        }
        return res;
    }

    private String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}