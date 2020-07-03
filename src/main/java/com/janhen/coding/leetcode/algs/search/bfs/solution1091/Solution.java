package com.janhen.coding.leetcode.algs.search.bfs.solution1091;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  // 8-directionally
  private int[][] dirs = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1},
               {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
  private int m, n;

  public int shortestPathBinaryMatrix(int[][] grid) {
    // 0.1 skip special input
    m = grid.length;
    n = grid[0].length;
    if (m == n && m == 1) {
      return 1;
    }
    if (grid[0][0] == 1)
      return -1;
    if (m == 0 && n == 0)
      return 1;
    // 0.2 define record search structure
    boolean[][] visited = new boolean[m][n];
    int[][] dis = new int[m][n];

    // BFS
    // two-dimension =>  one-dimension
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0][0] = true;
    dis[0][0] = 1;
    while (!queue.isEmpty()) {
      int cur = queue.remove();
      int curx = cur / n, cury = cur % n;
      for (int d = 0; d < 8; d++) {
        int nextX = curx + dirs[d][0];
        int nextY = cury + dirs[d][1];
        if (inArea(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
          queue.add(nextX * n + nextY);
          visited[nextX][nextY] = true;
          dis[nextX][nextY] = dis[curx][cury] + 1;
          if (nextX == m - 1 && nextY == n - 1)
            return dis[nextX][nextY];
        }
      }
    }
    return -1;
  }

  private boolean inArea(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}