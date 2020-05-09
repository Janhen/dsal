package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.sm_matrix_search.solution64;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i ++) {                // no need to handle init value
            for (int j = 0; j < n; j ++) {
                if (j == 0)                       // cannot left move AND include can not up move when i=0
                    dp[j] = dp[j] + grid[i][j];             // reuse to narraw space to prevent override
                else if (i == 0)
                    dp[j] = dp[j-1] + grid[i][j];      // can not up move
                else
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }

        return dp[n-1];
    }
}