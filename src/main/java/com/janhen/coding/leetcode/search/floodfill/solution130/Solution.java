package com.janhen.coding.leetcode.search.floodfill.solution130;

class Solution {

    // 7 ms, faster than 35.44%
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // traverse four edges and record visited
        for (int i = 0; i != n - 1; i ++)                        
            floodfill(board, 0, i, m, n, visited);
        for (int i = 0; i != m-1; i ++)
            floodfill(board, i, n-1, m, n, visited);
        for (int i = n-1; i != 0; i --)
            floodfill(board, m-1, i, m, n, visited);
        for (int i = m-1; i != 0; i --)
            floodfill(board, i, 0, m, n, visited);

        // traverse and modify matrix
        for (int i = 1; i < m - 1; i ++)
            for (int j = 1; j < n - 1; j ++)
                if (!visited[i][j] && board[i][j] == 'O')
                    floodfillAndModify(board, i, j, m, n, visited);
    }


    // 将从边界处出发的为 O 的都标记为访问过
    private void floodfill(char[][] board, int r, int c, int m, int n, boolean[][] visited) {
        if (outOfBound(r, c, m, n) || visited[r][c] || board[r][c] != 'O')
            return;
        visited[r][c] = true;
        floodfill(board, r - 1, c, m, n, visited);
        floodfill(board, r, c + 1, m, n, visited);
        floodfill(board, r + 1, c, m, n, visited);
        floodfill(board, r, c - 1, m, n, visited);
    }

    // 将中间的 O 全部替换成指定的格式
    private void floodfillAndModify(char[][] board, int r, int c, int m, int n, boolean[][] visited) {
        if (outOfBound(r,c,m, n) || visited[r][c] || board[r][c] != 'O')
            return;
        board[r][c] = 'X';
        visited[r][c] = true;
        floodfillAndModify(board, r - 1, c, m, n, visited);
        floodfillAndModify(board, r, c + 1, m, n, visited);
        floodfillAndModify(board, r + 1, c, m, n, visited);
        floodfillAndModify(board, r, c - 1, m, n, visited);
    }
    
    private boolean outOfBound(int r, int c, int m, int n) {
        return r >= m || r < 0 || c >= n || c < 0;
    }
}




