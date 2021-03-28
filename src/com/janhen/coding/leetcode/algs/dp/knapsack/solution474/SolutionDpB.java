package com.janhen.coding.leetcode.algs.dp.knapsack.solution474;

class SolutionDpB {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];
//        for (int i = 0; i <= m; i ++)
//            for (int j = 0; j <= n; j ++)
//                dp[0][i][j] = 0;
        for (int i = 1; i <= l; i ++) {
            int[] cnts = calculate(strs[i-1]);
            int cnt0 = cnts[0];
            int cnt1 = cnts[1];           /* NumberFormatException */
            for (int j = 0; j <= m; j ++) {
                for (int k = 0; k <= n; k ++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= cnt0 && k >= cnt1)     // put strs[l] in backpack
                        dp[i][j][k] = Math.max(1 + dp[i-1][j-cnt0][k-cnt1], dp[i-1][j][k]);
                }
            }
        }
        return dp[l][m][n];
    }

    private int[] calculate(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0')
                res[0] ++;
            else if (c == '1')
                res[1] ++;
            else
                throw new IllegalArgumentException();
        }
        return res;
    }
}