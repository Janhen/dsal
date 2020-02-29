package com.janhen.leetcode.dp.base.knapsack01;

public class SolutionDP {


    // 求解 knapsack 中最大价值
    // f(index, current capacity)
    // time : O(n * C)
    // space : O(n * C)
    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        int[][] memo = new int[n][C + 1];

        for (int j = 0; j <= C; j ++)                  // [0] 物品在容积为 j 的情况下的最大值,    省略各个物品在容积为0 的情况
            memo[0][j] = (j >= w[0] ? v[0] : 0);

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j <= C; j ++) {
                memo[i][j] = memo[i - 1][j];            /* P1: 不包含当前元素的最大值 */
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i-1][j], v[i] + memo[i - 1][j - w[i]]);    /* P2: 包含当前元素, C 为减去当前容量作为参照 */
            }
        }
        return memo[n - 1][C];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(new SolutionDP().knapsack01(c, p, bag));
    }
}
