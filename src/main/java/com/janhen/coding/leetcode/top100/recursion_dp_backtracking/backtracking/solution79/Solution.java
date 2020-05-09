package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.backtracking.solution79;

class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (backtracking(board, i, j, rows, cols, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, int r, int c, int rows, int cols, String word, int index, boolean[][] visited) {
        if (index == word.length())
            return true;
        if (r >= rows || r < 0 || c >= cols || c < 0 || visited[r][c] || board[r][c] != word.charAt(index))
            return false;
        visited[r][c] = true;
        boolean hasFound = backtracking(board, r - 1, c, rows, cols, word, index + 1, visited) ||
                backtracking(board, r, c + 1, rows, cols, word, index + 1, visited) ||
                backtracking(board, r + 1, c, rows, cols, word, index + 1, visited) ||
                backtracking(board, r, c - 1, rows, cols, word, index + 1, visited);
        if (!hasFound)
            visited[r][c] = false;
        return hasFound;
    }
}