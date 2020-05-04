package main.java.janhen.swordoffer.recursiont_dp.problem49;

public class Solution_my {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6) return N;

        int index2 = 0, index3 = 0, index5 = 0; // record * factor > pre
        int[] dp = new int[N];
        dp[0] = 1;        // first uggly number is 1
        for (int i = 1; i < N; i ++) {
            int nextMin = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            dp[i] = nextMin;
            while (dp[index2] * 2 <= nextMin)
                index2 ++;
            while (dp[index3] * 3 <= nextMin)
                index3 ++;
            while (dp[index5] * 5 <= nextMin)
                index5 ++;
        }
        return dp[N - 1];
    }
}
