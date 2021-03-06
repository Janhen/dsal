package com.janhen.coding.leetcode.algs.search.floodfill.solution130;

// 标记处那些从边界处开始为 O, 但是不能替换成 X 的元素
// 扫描整个矩阵，将 O 替换成 X
class Solution3 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        // first row AND last row
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0, m, n);
            dfs(board, i, n - 1, m, n);
        }

        // left col AND right col
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, m, n);
            dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        // traverse from four direction
        dfs(board, r - 1, c, m, n);
        dfs(board, r, c + 1, m, n);
        dfs(board, r + 1, c, m, n);
        dfs(board, r, c - 1, m, n);
    }
}




