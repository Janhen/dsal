package main.java.janhen.leetcode.solutions2.other.solution326;

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

// 12 ms, faster than 99.94%
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        while (n != 0) {
            if (n == 3) return true;
            if (n % 3 == 0) n/= 3;
            else return false;
        }
        return false;
    }
}