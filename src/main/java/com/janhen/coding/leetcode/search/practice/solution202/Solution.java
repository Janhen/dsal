package com.janhen.coding.leetcode.search.practice.solution202;

// 202. Happy Number
// https://leetcode.com/problems/happy-number/
// Easy
// Hash Table, Math

/*
判断一个数字是否是快乐数字
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
Starting with any positive integer,
replace the number by the sum of the squares of its digits,
and repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        int cur = n;
        Set<Integer> record = new HashSet<>();     // record to prevent loop
        while (cur != 1) {
            cur = getDigitSquare(cur);
            if (!record.contains(cur))
                record.add(cur);
            else           // in this have loop
                return false;
        }
        return true;
    }

    private int getDigitSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}