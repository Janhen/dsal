package com.janhen.coding.leetcode.algs.search.floodfill.solution200;

public class Solution2 {

  /* 修改原始数组元素实现, 将为遍历到的岛屿感染成专门的标识, 减少创建访问数组 */
  public static int numIslands(char[][] m) {
    if (m == null || m.length == 0)
      return 0;

    int M = m.length;
    int N = m[0].length;
    int res = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (m[i][j] == '1') {    // island is '2'
          res++;
          infect(m, i, j, M, N);
        }
      }
    }
    return res;
  }

  public static void infect(char[][] m, int i, int j, int N, int M) {
    if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != '1')
      return;
    m[i][j] = '2';
    infect(m, i + 1, j, N, M);
    infect(m, i - 1, j, N, M);
    infect(m, i, j + 1, N, M);
    infect(m, i, j - 1, N, M);
  }
}
