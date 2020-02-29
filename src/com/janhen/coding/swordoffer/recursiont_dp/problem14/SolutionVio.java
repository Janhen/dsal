package com.janhen.swordoffer.recursiont_dp.problem14;

// 14 减绳子
// leetcode
// https://leetcode.com/problems/integer-break/description/

public class SolutionVio {

    // time : O(n^n)
    // space : O(n)
    public int integerBreak(int n) {
        if (n == 1)
            return 1;
        int res = -1;
        for (int i = 1; i < n; i ++)
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));
        return res;
    }
}
