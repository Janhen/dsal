package com.janhen.coding.leetcode.search.backtracking.practice.solution79;

class Solution3 {

    private int         rows;
    private int         cols;
    private boolean[][] visited;
    int[][] next = new int[][]{{-1, 0},{0, 1}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (backTracking(board, row, col, word, 0))
                    return true;
        return false;
    }

    private boolean backTracking(char[][] board, int row, int col, String word, int path) {
        if (path == word.length() - 1)
            return board[row][col] == word.charAt(path);

        // first : for...for...(i, j) must in area and not visited
        if (board[row][col] == word.charAt(path)) {
            visited[row][col] = true;
            for (int i = 0; i < next.length; i++) {
                int newR = row + next[i][0], newC = col + next[i][1];
                if (inArea(newR, newC) && !visited[newR][newC] &&
                        backTracking(board, newR, newC, word, path + 1))
                    return true;
            }
            visited[row][col] = false;
        }
        return false;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
