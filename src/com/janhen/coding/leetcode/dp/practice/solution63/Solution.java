package com.janhen.leetcode.dp.practice.solution63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {    // use for matrix explicit semantic
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] = dp[j] + dp[j - 1];      // previous AND left result
            }
        }
        return dp[width - 1];
    }
}
