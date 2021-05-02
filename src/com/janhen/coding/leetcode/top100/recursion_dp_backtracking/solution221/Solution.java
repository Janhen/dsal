package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution221;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i ++)
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        for (int j = 0; j < m; j ++)
            dp[j][0] = matrix[j][0] == '1' ? 1 : 0;
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (matrix[i][j] == '1')           // [i][j] = 0 default is 0, no need to handle
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;     // left up,left, up Have one is 0 Then 0
                System.out.println(dp[i][j]);
            }
        }
        int maxLen = -1;
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                maxLen = Math.max(maxLen, dp[i][j]);
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        new Solution().maximalSquare(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}