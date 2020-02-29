package com.janhen.leetcode.search.practice.solution242;

// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/

class Solution2 {

    public boolean isAnagram(String s, String t) {
        int[] letters = new int[256];
        for (char c : s.toCharArray())
            letters[c] ++;
        for (char c : t.toCharArray())
            letters[c] --;
        for (int cnt : letters)
            if (cnt != 0)
                return false;
        return true;
    }
}