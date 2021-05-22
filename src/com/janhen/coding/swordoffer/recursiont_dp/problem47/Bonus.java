package com.janhen.coding.swordoffer.recursiont_dp.problem47;

public class Bonus {
    //
    // dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
    public int getMost(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dp = new int[m][n];
        // init first row and col ...
        dp[0][0] = board[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + board[j][0];
        }
        // calculate in middle element
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
