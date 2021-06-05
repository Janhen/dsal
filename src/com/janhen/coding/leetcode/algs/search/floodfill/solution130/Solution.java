package com.janhen.coding.leetcode.algs.search.floodfill.solution130;

class Solution {
    public void solve(char[][] board) {
        // 0.1 special input
        if (board == null || board.length == 0)
            return;
        // 0.2 prepare param and record
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 1. traverse four edges and record visited
        for (int i = 0; i != n - 1; i++)
            floodfillTag(board, 0, i, m, n, visited);
        for (int i = 0; i != m - 1; i++)
            floodfillTag(board, i, n - 1, m, n, visited);
        for (int i = n - 1; i != 0; i--)
            floodfillTag(board, m - 1, i, m, n, visited);
        for (int i = m - 1; i != 0; i--)
            floodfillTag(board, i, 0, m, n, visited);

        // 2. traverse and modify matrix
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (!visited[i][j] && board[i][j] == 'O')
                    floodfillModify(board, i, j, m, n, visited);
    }

    // 将从边界处出发的为 O 的都标记为访问过
    private void floodfillTag(char[][] board, int r, int c, int m, int n, boolean[][] visited) {
        if (!inArea(r, c, m, n) || visited[r][c] || board[r][c] != 'O')
            return;
        visited[r][c] = true;
        floodfillTag(board, r - 1, c, m, n, visited);
        floodfillTag(board, r, c + 1, m, n, visited);
        floodfillTag(board, r + 1, c, m, n, visited);
        floodfillTag(board, r, c - 1, m, n, visited);
    }

    // 将中间的 O 全部替换成指定的格式
    private void floodfillModify(char[][] board, int r, int c, int m, int n, boolean[][] visited) {
        if (!inArea(r, c, m, n) || visited[r][c] || board[r][c] != 'O')
            return;
        board[r][c] = 'X';
        visited[r][c] = true;
        floodfillModify(board, r - 1, c, m, n, visited);
        floodfillModify(board, r, c + 1, m, n, visited);
        floodfillModify(board, r + 1, c, m, n, visited);
        floodfillModify(board, r, c - 1, m, n, visited);
    }

    private boolean inArea(int r, int c, int m, int n) {
        return r < m && r >= 0 && c < n && c >= 0;
    }
}