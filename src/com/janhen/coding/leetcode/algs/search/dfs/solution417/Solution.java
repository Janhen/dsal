package com.janhen.coding.leetcode.algs.search.dfs.solution417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int m, n;
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Tuple tuple = new Tuple();
                backtracking(matrix, i, j, tuple, visited);
                if (tuple.isCan()) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void backtracking(int[][] matrix, int r, int c, Tuple tuple, boolean[][] visited) {
        // 1.1 terminal condition: not meet condition
        if (!inArea(r, c) || visited[r][c]) {
            return;
        }
        // 1.2 terminal condition: meet condition, 带有状态记录的回溯, 在找到结果后快速退出
        if (tuple.isCan())
            return;

        // 2. judge meet condition result:find flow to edge, 边界统计
        if (inEdge(r, c)) {
            if (r == 0 || c == 0) {
                tuple.leftUp = true;
            }
            if (r == m - 1 || c == n - 1) {
                tuple.rightDown = true;
            }
        }

        // 3. backtracking in possible four direction to find
        visited[r][c] = true;
        for (int[] d : direction) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (inArea(nextR, nextC) && matrix[nextR][nextC] <= matrix[r][c]) {
                backtracking(matrix, nextR, nextC, tuple, visited);
            }
        }
        // 4. backtracking to back
        visited[r][c] = false;
    }

    private boolean inArea(int r, int c) {
        return r < m && r >= 0 && c < n && c >= 0;
    }

    private boolean inEdge(int r, int c) {
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