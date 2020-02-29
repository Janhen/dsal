package com.janhen.leetcode.string.solution345;

//345. Reverse Vowels of a String
//        https://leetcode.com/problems/reverse-vowels-of-a-string/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u','A','E','I','O','U'));

    public String reverseVowels(String s) {
        char[] chs = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char lCh = s.charAt(i), rCh = s.charAt(j);
            if (!vowels.contains(lCh))
                chs[i ++] = lCh;                        // not change
            else if (!vowels.contains(rCh))
                chs[j --] = rCh;
            else {
                chs[i ++] = rCh;
                chs[j --] = lCh;       // swap
            }
        }
        return new String(chs);
    }
}