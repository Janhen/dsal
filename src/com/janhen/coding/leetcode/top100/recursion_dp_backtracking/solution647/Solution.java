package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution647;

class Solution {
    private int count;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i ++) {     // [len-1] also one result
            expand(s, i, i);   // [i] as center
            expand(s, i, i +1);
        }
        return count;
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count ++;    // in this loop , is one possibility
            i --;
            j ++;
        }
    }
}