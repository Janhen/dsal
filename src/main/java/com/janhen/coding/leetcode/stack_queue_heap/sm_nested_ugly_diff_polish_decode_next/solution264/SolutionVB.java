package main.java.janhen.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution264;

//264. Ugly Number II
//https://leetcode.com/problems/ugly-number-ii/

/*

Medium

742p

53

Favorite

Share
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
 */

class SolutionVB {
    
    public int nthUglyNumber(int n) {
        int num = 0;
        int cnt = 0;
        while (cnt < n) {
            num ++;
            if (isUgly(num)) {
                cnt ++;
            }
        }
        return num;
    }

    private boolean isUgly(int num) {
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1 ? true : false;
    }
}