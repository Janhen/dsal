package main.java.janhen.swordoffer.a_good.problem12;

public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] M = buildMatrix(matrix, rows, cols);
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (backtracking(M, i, j, rows, cols, 0, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] M, int r, int c, int rows, int cols, int index, char[] str, boolean[][] visited) {
        if (index == str.length) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || str[index] != M[r][c]) {
            return false;
        }
        visited[r][c] = true;
        boolean hasFound = backtracking(M, r + 1, c, rows, cols, index + 1, str, visited)
                || backtracking(M, r , c + 1, rows, cols, index + 1, str, visited)
                || backtracking(M, r - 1, c, rows, cols, index + 1, str, visited)
                || backtracking(M, r, c - 1, rows, cols, index + 1, str, visited);
        if (!hasFound) {
            visited[r][c] = false;
        }
        return hasFound;
    }

    private char[][] buildMatrix(char[] matrix, int rows, int cols) {
        int idx = 0;
        char[][] M = new char[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                M[i][j] = matrix[idx ++];
            }
        }
        return M;
    }
}
