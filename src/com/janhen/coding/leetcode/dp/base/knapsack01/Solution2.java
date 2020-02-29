package com.janhen.leetcode.dp.base.knapsack01;

import java.util.Arrays;

public class Solution2 {

    private int[][] memo;

    // 求解 knapsack 中最大价值
    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        memo = new int[n][C + 1];
        for (int[] a : memo)
            Arrays.fill(a, -1);

        return bestValue(w, v, n - 1, C);
    }

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        memo[index][c] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(new Solution2().knapsack01(c, p, bag));
    }
}
