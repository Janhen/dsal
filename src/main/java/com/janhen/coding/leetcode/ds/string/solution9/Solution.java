package com.janhen.coding.leetcode.ds.string.solution9;

class Solution {
    public boolean isPalindrome(int x) {
        // convert to char[] handle
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}