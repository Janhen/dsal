package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution680;

class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {    // odd i+1=j-1, even: j-i=1
            if (s.charAt(i) != s.charAt(j)) {
                // two condition to verify
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}