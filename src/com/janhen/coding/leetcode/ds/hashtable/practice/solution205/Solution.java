package com.janhen.coding.leetcode.ds.hashtable.practice.solution205;

/*
 * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // char -> lastOccurIdx
        int[] valIdx1 = new int[256];
        int[] valIdx2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (valIdx1[s.charAt(i)] != valIdx2[t.charAt(i)]) {
                return false;
            }
            valIdx1[s.charAt(i)] = i + 1;
            valIdx2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}