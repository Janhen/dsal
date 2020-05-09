package com.janhen.coding.leetcode.dp.practice.solution63;

class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        obstacleGrid[0][0] ^= 1;  // 1 ⇒ 0, 0 ⇒ 1
        for (int i = 1; i < m; i ++)  // first col, only rely on up
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
        for (int j=1; j<n; j ++)   // first row, only rely on left
            obstacleGrid[0][j] = obstacleGrid[0][j] == 1 ? 0 : obstacleGrid[0][j-1];
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1 ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
