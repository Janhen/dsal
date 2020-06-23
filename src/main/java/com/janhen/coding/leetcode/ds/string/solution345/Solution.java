package com.janhen.coding.leetcode.ds.string.solution345;

//345. Reverse Vowels of a String
//        https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// easy
// two pointers, string

/*
翻转字符串中的元音字符

Input: "hello"
Output: "holle"

Input: "leetcode"
Output: "leotcede"
 */

import java.util.*;

// 5 ms, faster than 72.83%
class Solution {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o','u','A','E','I','O','U'));

    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!vowels.contains(chs[i]) && i < j) i ++;   // find first vowel
            while (!vowels.contains(chs[j]) && i < j) j --;
            swap(chs, i ++, j --);
        }
        return new String(chs);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}