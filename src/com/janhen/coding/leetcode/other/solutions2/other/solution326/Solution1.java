package com.janhen.coding.leetcode.other.solutions2.other.solution326;

// 326. Power of Three
//https://leetcode.com/problems/power-of-three/description/

/*

Easy

236

901

Favorite

Share
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
 */

class Solution1 {
    // todo Q
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}