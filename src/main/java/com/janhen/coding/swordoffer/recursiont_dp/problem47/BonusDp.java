package main.java.janhen.swordoffer.recursiont_dp.problem47;

public class BonusDp {
    public int getMost(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            dp[0] += board[i][0];              // first column only can down collect result
            for (int j = 1; j < n; j++) {
                dp[j] = board[i][j] + Math.max(dp[j], dp[j-1]);
            }
        }
        return dp[n - 1];
    }
}
