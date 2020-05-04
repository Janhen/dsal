package main.java.janhen.swordoffer.recursiont_dp.problem13;

public class Solution {

    // 有条件的遍历行为
    // 保存矩阵的数字和, help[] 防止重复计算
    public int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        int[][] digitSum = geneDigitSum(rows, cols);
        count = dfs(threshold, 0, 0, rows, cols, visited, digitSum);
        return count;
    }

    private int dfs(int threshold, int row, int col, int rows, int cols, boolean[][] visited, int[][] digitSum) {
        if (!canRun(threshold, row, col, rows, cols, visited, digitSum))
            return 0;
        visited[row][col] = true;
        int count = 0;
        count = 1 + dfs(threshold, row, col - 1, rows, cols, visited, digitSum)
                + dfs(threshold, row, col + 1, rows, cols, visited, digitSum)
                + dfs(threshold, row - 1, col, rows, cols, visited, digitSum)
                + dfs(threshold, row + 1, col, rows, cols, visited, digitSum);
        return count;
    }

    private boolean canRun(int threshold, int row, int col, int rows, int cols, boolean[][] visited, int[][] digitSum) {
        if (row >= rows || row < 0 || col >= cols || col < 0 || visited[row][col] || digitSum[row][col] > threshold)
            return false;
        return true;
    }

    // use table to save calculated value
    private int[][] geneDigitSum(int rows, int cols) {
        int[] help = new int[Math.max(rows, cols)];
        for (int i = 0; i < help.length; i ++) {
            int num = i;
            while (num > 0) {
                help[i] += num % 10;
                num /= 10;
            }
        }
        int[][] digitSum = new int[rows][cols];
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                digitSum[i][j] = help[i] + help[j];
            }
        }
        return digitSum;
    }
}
