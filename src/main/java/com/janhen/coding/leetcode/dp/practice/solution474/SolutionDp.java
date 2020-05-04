package main.java.janhen.leetcode.dp.practice.solution474;

class SolutionDp {
    // 这是一个多维费用的 0-1 背包问题，有两个背包大小，0 的数量和 1 的数量。
    public int findMaxForm(String[] strs, int m, int n) {        /* 统计最大个数问题 */
        int[][] dp = new int[m+1][n+1];
        for (int k = 0; k < strs.length; k ++) {
            int[] cnts = calcCnt(strs[k]);
            int cnt0 = cnts[0], cnt1 = cnts[1];           /* NumberFormatException */
            for (int i = m; i >= cnt0; i --) {
                for (int j = n; j >= cnt1; j --) {
                    dp[i][j] = Math.max(1 + dp[i-cnt0][j-cnt1], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] calcCnt(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            if (c == '0')
                res[0] ++;
            else if (c == '1')
                res[1] ++;
            else
                throw new RuntimeException();
        }
        return res;
    }
}