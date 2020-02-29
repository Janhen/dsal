package com.janhen.swordoffer.recursiont_dp.problem47;

public class Bonus1 {

    // 二维数组
    public int getMost(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0, up = 0;
                if (i >= 1) left = dp[i - 1][j];
                if (j >= 1) up = dp[i][j - 1];
                dp[i][j] = Math.max(left, up) + board[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
