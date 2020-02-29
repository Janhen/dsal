package com.janhen.leetcode.top100.recursion_dp_backtracking.dfs.solution200;

class Solution1 {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {   // can visited many time '1'
                    res++;
                    floodFill(grid, i, j, rows, cols, visited);
                }
            }
        }
        return res;
    }

    private void floodFill(char[][] grid, int r, int c, int rows, int cols, boolean[][] visited) {
        if (r >= rows || r < 0 || c >= cols || c < 0 || visited[r][c] || grid[r][c] != '1')
            return;
        visited[r][c] = true;
        floodFill(grid, r - 1, c, rows, cols, visited);
        floodFill(grid, r, c + 1, rows, cols, visited);
        floodFill(grid, r + 1, c, rows, cols, visited);
        floodFill(grid, r, c - 1, rows, cols, visited);
        return;
    }

    public static void main(String[] args) {

        char grid1[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new Solution1()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new Solution1()).numIslands(grid2));
        // 3
    }
}
