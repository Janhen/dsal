package com.janhen.coding.leetcode.algs.search.dfs.solution417;

import java.util.ArrayList;
import java.util.List;

class Solution2 {

  // 127 ms, faster than 10.14%
  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0)
      return res;
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[][] canReachP = new boolean[m][n];
    boolean[][] canReachA = new boolean[m][n];                /* 分别记录两种边界的可达性状况 */

    for (int i = 0; i < m; i++) {                     /* 从已知可达边界出发进行 DFS */
      dfs(matrix, i, 0, m, n, canReachP);
      dfs(matrix, i, n - 1, m, n, canReachA);
    }

    for (int i = 0; i < n; i++) {
      dfs(matrix, 0, i, m, n, canReachP);
      dfs(matrix, m - 1, i, m, n, canReachA);
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (canReachP[i][j] && canReachA[i][j]) {
          res.add(new int[]{i, j});
        }
      }
    }
    return res;
  }

  // 从多个根节点出发进行有条件的 DFS
  private void dfs(int[][] matrix, int r, int c, int m, int n, boolean[][] canReach) {
    if (canReach[r][c])
      return;
    canReach[r][c] = true;
    if (r - 1 >= 0 && matrix[r - 1][c] <= matrix[r][c])
      dfs(matrix, r - 1, c, m, n, canReach);
    if (c + 1 < n && matrix[r][c + 1] <= matrix[r][c])
      dfs(matrix, r, c + 1, m, n, canReach);
    if (r + 1 < m && matrix[r + 1][c] <= matrix[r][c])
      dfs(matrix, r + 1, c, m, n, canReach);
    if (c - 1 >= 0 && matrix[r][c - 1] <= matrix[r][c])
      dfs(matrix, r, c - 1, m, n, canReach);
  }
}