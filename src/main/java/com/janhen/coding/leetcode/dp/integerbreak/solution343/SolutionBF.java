package com.janhen.coding.leetcode.dp.integerbreak.solution343;

class SolutionBF {

    // time : O(n^n), space : O(n)
    public int integerBreak(int n) {

        if (n == 1)
            return 1;

        int res = -1;

        for (int i = 1; i < n; i ++) {
            // 从此处分割一次, 分割多次
            int splitMax = Math.max(i * (n - i), i * integerBreak(n - i));
            res = Math.max(res, splitMax);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = (new SolutionBF()).integerBreak(10);
        System.out.println(i);
    }

}