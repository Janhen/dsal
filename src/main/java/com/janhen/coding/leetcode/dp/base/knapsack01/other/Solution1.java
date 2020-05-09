package com.janhen.coding.leetcode.dp.base.knapsack01.other;


// check??
public class Solution1 {

    // violence recursion
    // 求解 knapsack 中最大价值
    // - w : item weight or volume
    // - v : item value
    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        return bestValue(w, v, C, 0, 0);   // reverse recursion
    }

    private int bestValue(int[] w, int[] v, int C, int index, int alreadyC) {
        if (alreadyC > C)
            return 0;

        if (index == w.length)
            return 0;

        return Math.max(bestValue(w, v, C, index + 1, alreadyC),
                v[index] + bestValue(w, v, C, index + 1, alreadyC + w[index]));
    }
}
