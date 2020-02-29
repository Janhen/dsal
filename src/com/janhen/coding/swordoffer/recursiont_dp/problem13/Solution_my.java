package com.janhen.swordoffer.recursiont_dp.problem13;

public class Solution_my {

    int cnt = 0;
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        dfs(0, 0, rows, cols, threshold, visited);    // only need think from (0,0) position
        return cnt;
    }

    private void dfs(int r, int c, int rows, int cols, int threshold, boolean[][] visited) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || !canRun(r,c, threshold)) {
            return;
        }
        visited[r][c] = true;                           // can visit is one possibility from (0,0)
        cnt ++;                                         // when can into cycle, is one possibility
        dfs(r +1, c, rows, cols, threshold, visited);
        dfs(r , c + 1, rows, cols, threshold, visited);
        dfs(r - 1, c, rows, cols, threshold, visited);
        dfs(r , c-1, rows, cols, threshold, visited);
    }

    private boolean canRun(int r, int c, int threshold) {
        return getDigitSum(r) + getDigitSum(c) <= threshold;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
