package com.janhen.leetcode.solutions2.other.solution367;

// 367. Valid Perfect Square
//https://leetcode.com/problems/valid-perfect-square/description/

/*

Easy

396

95

Favorite

Share
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 */

class Solution {
    // (x+1)^2-x^2 = 2x + 1
    // 1, 4, 9, 16, ...
    //   3, 5, 7, ...
    public boolean isPerfectSquare(int num) {
        int sum = 1;
        while (num > 0) {
            num -= sum;
            sum += 2;
        }
        return num == 0;
    }
}