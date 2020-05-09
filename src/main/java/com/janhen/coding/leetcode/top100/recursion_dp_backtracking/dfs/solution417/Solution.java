package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.dfs.solution417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                Pair pair = new Pair();
                backtracking(matrix, i, j, pair, m, n, visited);
                if (pair.isCan()) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void backtracking(int[][] matrix, int r, int c, Pair pair, int m, int n, boolean[][] visited) {
        if (r >= m || r < 0 || c >= n || c < 0 || visited[r][c]) {
            return;
        }
        if (pair.isCan())        /* 带有状态记录的回溯, 在找到结果后快速退出 */
            return;
        if (r == 0 || c == 0 || r == m-1 || c == n-1) {           /* 边界统计, note: 拐角处两边都可以 */
            if (r == 0 || c == 0) {
                pair.leftUp = true;
            }
            if (r == m - 1 || c == n - 1) {
                pair.rightDown = true;
            }
        }
        // r, c can four direction
        visited[r][c] = true;
        if (r-1 >= 0 && matrix[r - 1][c] <= matrix[r][c])
            backtracking(matrix, r-1, c, pair, m, n, visited);
        if (c + 1 < n && matrix[r][c + 1] <= matrix[r][c])
            backtracking(matrix, r, c + 1, pair, m, n, visited);
        if (r + 1 < m && matrix[r + 1][c] <= matrix[r][c])
            backtracking(matrix, r+1, c, pair, m, n, visited);
        if (c-1 >= 0 && matrix[r][c-1] <= matrix[r][c])
            backtracking(matrix, r, c-1, pair, m, n, visited);
        visited[r][c] = false;
    }

    class Pair {
        boolean leftUp;
        boolean rightDown;

        boolean isCan() {
            return leftUp == true && rightDown == true;
        }
    }
}