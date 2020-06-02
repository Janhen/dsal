package com.janhen.coding.leetcode.graphdfsbfs.floodfill.solution200;

class SolutionRef2 {

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean[][] visited;
    private int         rows, cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1')
                dfs(grid, newX, newY);
        }
        return;
    }

    private boolean inArea(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) {

        char grid1[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println((new SolutionRef2()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println((new SolutionRef2()).numIslands(grid2));
        // 3
    }
}
