package com.janhen.coding.leetcode.other.solution387;

// 387. First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/description/

class Solution {

    // traverse two times
    // time : O(n), space : O(1)
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        // Word frequency statistics
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            freq[c - 'a'] ++;
        }
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
