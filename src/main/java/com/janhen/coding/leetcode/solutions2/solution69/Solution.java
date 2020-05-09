package com.janhen.coding.leetcode.solutions2.solution69;

// 69. Sqrt(x)
//https://leetcode.com/problems/sqrtx/

/*

Easy

648

1189

Favorite

Share
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

class Solution {
    public int mySqrt(int x) {
        // c
        if (x <= 1)
            return x;
        // sqrt*sqrt=x ⇒ sqrt=x/sqrt ⇒ find sqrt
        int lo = 1, hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sqrt = x/mid;
            if (sqrt == mid)
                return mid;
            else if (sqrt < mid)
                hi = mid -1;
            else
                lo = mid + 1;
        }
        return hi;
    }
}