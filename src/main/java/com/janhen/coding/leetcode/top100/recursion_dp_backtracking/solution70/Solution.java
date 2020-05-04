package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution70;

class Solution {
    /* f(n) = f(n-1) + f(n-2) */
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int res = -1;
        int preOne = 2;
        int preTwo = 1;
        for (int i = 3; i <= n; i ++) {
            res = preOne + preTwo;
            preTwo = preOne;
            preOne = res;
        }
        return res;
    }
}