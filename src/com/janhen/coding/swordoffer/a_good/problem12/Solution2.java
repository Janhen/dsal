package com.janhen.coding.swordoffer.a_good.problem12;

public class Solution2 {

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] arr, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0)  return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] visited = new boolean[rows][cols];
        char[][] matrix = buildMatrix(arr);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] visited, int pathLen, int row, int col) {
        if (pathLen == str.length) {
            return true;
        }
        if (row <0 || row >= rows || col < 0 || col >= cols || matrix[row][col] != str[pathLen] || visited[row][col] )
            return false;

        visited[row][col] = true;
        for (int[] nArr : next) {
            if (backtracking(matrix, str, visited, pathLen + 1, row + nArr[0], col + nArr[1])) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private char[][] buildMatrix(char[] arr) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = arr[idx++];
        return matrix;
    }
}
