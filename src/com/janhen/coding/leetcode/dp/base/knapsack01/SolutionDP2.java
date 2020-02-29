package com.janhen.leetcode.dp.base.knapsack01;

public class SolutionDP2 {

    // dp[i][j] = max{v[i]+dp[i-1][j-w[i]], dp[i-1][j]}
    //  ⇒  dp[j] = max{v[i] + dp[j-w[i]], dp[j]]            dp[j] 为不断赋值过程中以前的旧值
    // reuse array space
    //      only rely on previous value
    // time : O(n * C)
    // space : O(C)
    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        int[][] memo = new int[2][C + 1];

        for (int j = 0; j <= C; j ++)
            memo[0][j] = (j >= w[0] ? v[0] : 0);    // first row

        for (int i = 1; i < n; i ++) {
            for (int j = 0; j <= C; j ++) {    /* [(i-1)%2] 存储的为上一个元素是否添加进去的最大价值, 防止了覆盖问题 */
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i])
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
            }
        }
        return memo[(n - 1) % 2][C];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(new SolutionDP2().knapsack01(c, p, bag));
    }
}
