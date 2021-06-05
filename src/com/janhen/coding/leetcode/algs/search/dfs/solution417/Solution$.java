package com.janhen.coding.leetcode.algs.search.dfs.solution417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution$ {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Tuple tuple = new Tuple();
                backtracking(matrix, i, j, tuple, m, n, visited);
                if (tuple.isCan()) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void backtracking(int[][] matrix, int r, int c, Tuple tuple, int m, int n, boolean[][] visited) {
        // 1.1 terminal condition: not meet condition
        if (!inArea(r, c, m, n) || visited[r][c]) {
            return;
        }
        // 1.2 terminal condition: meet condition
        if (tuple.isCan())        /* 带有状态记录的回溯, 在找到结果后快速退出 */
            return;

        // 2. judge meet condition result:find flow to edge
        if (inEdge(r, c, m, n)) {           /* 边界统计, note: 拐角处两边都可以 */
            if (r == 0 || c == 0) {
                tuple.leftUp = true;
            }
            if (r == m - 1 || c == n - 1) {
                tuple.rightDown = true;
            }
        }

        // 3. backtracking in possible four direction to find
        visited[r][c] = true;
        if (r - 1 >= 0 && matrix[r - 1][c] <= matrix[r][c])
            backtracking(matrix, r - 1, c, tuple, m, n, visited);
        if (c + 1 < n && matrix[r][c + 1] <= matrix[r][c])
            backtracking(matrix, r, c + 1, tuple, m, n, visited);
        if (r + 1 < m && matrix[r + 1][c] <= matrix[r][c])
            backtracking(matrix, r + 1, c, tuple, m, n, visited);
        if (c - 1 >= 0 && matrix[r][c - 1] <= matrix[r][c])
            backtracking(matrix, r, c - 1, tuple, m, n, visited);
        visited[r][c] = false;
    }

    private boolean inArea(int r, int c, int m, int n) {
        return r < m && r >= 0 && c < n && c >= 0;
    }

    private boolean inEdge(int r, int c, int m, int n) {
        return r == 0 || c == 0 || r == m - 1 || c == n - 1;
    }

    class Tuple {
        boolean leftUp;
        boolean rightDown;

        boolean isCan() {
            return leftUp == true && rightDown == true;
        }
    }
}