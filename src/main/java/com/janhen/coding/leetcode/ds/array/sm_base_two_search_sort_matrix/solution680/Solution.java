package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution680;

//

/*

 */

class Solution {
    // todo error
    public boolean validPalindrome(String s) {
        boolean canDelete = true;
        boolean isPalindrome = true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else if (canDelete && i+1<j && s.charAt(i+1) == s.charAt(j)) {   // 存在跳过 [i] 相等, 跳过[j] 相等的两种情况
                i++;
                i ++;
                j--;
                canDelete = false;
            } else if (canDelete && j-1>i && s.charAt(j-1) == s.charAt(i)) {
                j--;
                i++;
                j --;
                canDelete = false;
            } else {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome)
            return isPalindrome;

        i = 0;
        j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i ++;
                j --;
            } else if (canDelete && j-1>i && s.charAt(j-1) == s.charAt(i)) {
                j--;
                i++;
                j --;
                canDelete = false;
            } else if (canDelete && i+1<j && s.charAt(i+1) == s.charAt(j)) {   // 存在跳过 [i] 相等, 跳过[j] 相等的两种情况
                i++;
                i ++;
                j--;
                canDelete = false;
            } else
                return false;
        }
        return true;
    }
}