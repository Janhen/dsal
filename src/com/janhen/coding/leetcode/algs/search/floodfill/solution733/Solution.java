package com.janhen.coding.leetcode.algs.search.floodfill.solution733;

class Solution {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return 0;
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int res = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && grid[i][j] == '1') {   // can visited many time '1'
          res++;
          // dfs to record four direction element visited
          floodFill(grid, i, j, m, n, visited);
        }
      }
    }
    return res;
  }

  private void floodFill(char[][] grid, int r, int c, int m, int n, boolean[][] visited) {
    if (outOfBound(r, c, m, n) || visited[r][c] || grid[r][c] != '1')
      return;
    visited[r][c] = true;
    floodFill(grid, r - 1, c, m, n, visited);
    floodFill(grid, r, c + 1, m, n, visited);
    floodFill(grid, r + 1, c, m, n, visited);
    floodFill(grid, r, c - 1, m, n, visited);
    return;
  }

  private boolean outOfBound(int r, int c, int m, int n) {
    return r >= m || r < 0 || c >= n || c < 0;
  }
}
