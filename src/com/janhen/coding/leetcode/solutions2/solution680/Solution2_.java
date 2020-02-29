package com.janhen.leetcode.solutions2.solution680;

// 680. Valid Palindrome II
//https://leetcode.com/problems/valid-palindrome-ii/

/*

Easy

610

41

Favorite

Share
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */

// 22 ms, faster than 55.60%
class Solution2_ {

    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++ i < -- j) {    // odd i+1=j-1, even: j-i=1;
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i, j-1) || isPalindrome(s, i+1,j);   // 右指针左移一位, 左指针右移一位
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i ++) != s.charAt(j --))
                return false;
        }
        return true;
    }
}