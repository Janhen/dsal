package main.java.janhen.leetcode.solutions2.solution633;

// 633. Sum of Square Numbers
//https://leetcode.com/problems/sum-of-square-numbers/description/

/*

Easy

294

205

Favorite

Share
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5


Example 2:

Input: 3
Output: False
 */

// 8 ms, faster than 80.55%
class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int)Math.sqrt(c);
        while (i <= j) {
            int squareSum = i * i + j * j;
            if (squareSum == c)
                return true;
            else if (squareSum < c)
                i ++;
            else
                j --;
        }
        return false;
    }
}