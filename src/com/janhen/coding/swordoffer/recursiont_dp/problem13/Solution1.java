package com.janhen.coding.swordoffer.recursiont_dp.problem13;

public class Solution1 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        int count = dfs(threshold, 0, 0, rows, cols, visited);
        return count;
    }

    private int dfs(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
        if (!canRun(threshold, row, col, rows, cols, visited))
            return 0;
        visited[row][col] = true;
        int count = 1 + dfs(threshold, row, col - 1, rows, cols, visited) + dfs(threshold, row, col + 1, rows, cols, visited) + dfs(threshold, row - 1, col, rows, cols, visited) + dfs(threshold, row + 1, col, rows, cols, visited);
        return count;
    }

    private boolean canRun(int threshold, int row, int col, int rows, int cols, boolean[][] visited) {
        if (row >= rows || row < 0 || col >= cols || col < 0 || visited[row][col] || isOverThreshold(row, col, threshold))
            return false;
        return true;
    }

    // may Double counting in rows and cols not equal
    private boolean isOverThreshold(int i, int j, int threshold) {
        return getDigitSum(i) + getDigitSum(j) > threshold;
    }

    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
