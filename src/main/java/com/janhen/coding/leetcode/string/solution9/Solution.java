package com.janhen.coding.leetcode.string.solution9;

// 9. Palindrome Number
//https://leetcode.com/problems/palindrome-number/description/

/*
Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */

class Solution {
    public boolean isPalindrome(int x) {
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