package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.dfs.solution200;

class SolutionRef {

    private int M, N;
    private boolean[][] visited;
    private int[][]     dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        M = grid.length;
        N = grid[0].length;
        visited = new boolean[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {   // can visited many time '1'
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // flood fill: not reset
    private void dfs(char[][] grid, int r, int c) {
        if (r >= M || r < 0 || c >= N || c < 0 || visited[r][c] || grid[r][c] != '1')
            return;
        visited[r][c] = true;
        for (int i = 0; i < dirs.length; i++)
            dfs(grid, r + dirs[i][0], c + dirs[i][1]);
        return;
    }


    public static void main(String[] args) {

        char grid1[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new SolutionRef()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new SolutionRef()).numIslands(grid2));
        // 3
    }
}
