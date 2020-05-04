package main.java.janhen.leetcode.dp.solution343;

//343. Integer Break
//        https://leetcode.com/problems/integer-break/description/

import java.util.Arrays;

class SolutionMemo {

    private int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];
        int res = -1;
        for (int i = 1; i < n; i ++)
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        return  memo[n] = res;
    }
}