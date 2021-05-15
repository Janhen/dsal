package com.janhen.coding.leetcode.ds.array.sm_base_two_search_sort_matrix.solution73;

class SolutionF {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowAffect = false;
        boolean colAffect = false;
        // 1. init flag in first row, first col; record first row, first col is or not reset to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) rowAffect = true;
                    if (j == 0) colAffect = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 2. reset other row, and col to 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        // 3. handle first row, first col
        if (rowAffect) {
            cleanRow(0, matrix);
        }
        if (colAffect) {
            cleanCol(0, matrix);
        }
    }

    private void cleanRow(int row, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void cleanCol(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
