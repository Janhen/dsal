package com.janhen.coding.leetcode.ds.hashtable.practice.solution242;

import java.util.Arrays;

class Solution3 {
    // 排序比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}