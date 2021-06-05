package com.janhen.coding.leetcode.algs.search.backtracking.practice.solution79;

class Solution {
    private int m;
    private int n;
    private boolean[][] visited;
    private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        // 0.1 return special input
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        // 0.2 record prepare param
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        // 1. iterate matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 2. find in four direction
                if (backtracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int row, int col, int index) {
        if (index == word.length())
            return true;
        if (!inArea(row, col) || visited[row][col] || board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;
        for (int i = 0; i < dirs.length; i++) {
            if (backtracking(board, word, row + dirs[i][0], col + dirs[i][1], index + 1))    // find then terminate
                return true;
        }
        visited[row][col] = false;
        return false;
    }

    private boolean inArea(int row, int col) {
        return row < m && row >= 0 && col < n && col >= 0;
    }
}
