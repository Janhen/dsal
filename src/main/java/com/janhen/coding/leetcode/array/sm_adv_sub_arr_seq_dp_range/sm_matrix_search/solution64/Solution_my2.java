package main.java.janhen.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution64;

public class Solution_my2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (j == 0) {     // first col, only can a_base up
                    dp[j] = dp[j] + grid[i][j];
                } else if (i == 0) {    // first row, only can a_base left
                    dp[j] = dp[j - 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];

    }
}
