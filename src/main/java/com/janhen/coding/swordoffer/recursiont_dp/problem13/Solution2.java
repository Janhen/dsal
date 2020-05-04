package main.java.janhen.swordoffer.recursiont_dp.problem13;

public class Solution2 {
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int count = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;       // 记录矩阵元素数字和

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return count;
    }

    private void dfs(boolean[][] marked, int row, int col) {
        marked[row][col] = true;
        if (digitSum[row][col] > this.threshold)
            return ;
        count ++;
        for (int[] nArr : next) {
            int newR = row + nArr[0];
            int newC = col + nArr[1];
            if (inArea(newR, newC, marked))
                dfs(marked, row + nArr[0], col + nArr[1]);
        }
    }

    private boolean inArea(int r, int c, boolean[][] marked) {
        if (r >= 0 && r < rows && c >= 0 && c < cols && !marked[r][c])
            return true;
        return false;
    }

    private void initDigitSum() {
        int[] helper = new int[Math.max(rows, cols)];
        for (int i = 0; i < helper.length; i++) {
            int num = i;
            while (num > 0) {
                helper[i] += num % 10;
                num /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.digitSum[i][j] = helper[i] + helper[j];
            }
        }
    }
}
