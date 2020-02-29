package com.janhen.leetcode.string.solution125;

// 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/description/
// easy
// two pointers, string

/*
验证是否为回文串

只考虑字母且忽略大小写

Input: "A man, a plan, a canal: Panama"
Output: true

Input: "race a car"
Output: false
 */

public class Solution {

    // Character:
    //    - isLetter(c)
    //    - isLetterOrDigit(c)
    //    - toLowerCase(c): char return can compare
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lCh = s.charAt(l);
            char rCh = s.charAt(r);
            if (!Character.isLetterOrDigit(lCh))
                l ++;
            else if (!Character.isLetterOrDigit(rCh))
                r --;
            else {
                if (Character.toLowerCase(lCh) != Character.toLowerCase(rCh))
                    return false;
                l ++;
                r --;
            }
        }
        return true;
    }
}