package com.janhen.coding.leetcode.algs.search.bfs.solution279;

import java.util.Arrays;

class SolutionDP {
    /*
    dp[0] = 0
    dp[1] = dp[0]+1 = 1
    dp[2] = dp[1]+1 = 2
    dp[3] = dp[2]+1 = 3
    dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
          = Min{ dp[3]+1, dp[0]+1 }
          = 1
    dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
          = Min{ dp[4]+1, dp[1]+1 }
          = 2
                            .
                            .
                            .
    dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
           = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
           = 2
                            .
                            .
                            .
    dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     */
    //  46 ms, faster than 38.34%
    //25.6 MB, less than 51.84%
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE, num = 1;
            while (i - num * num >= 0) {
                min = Math.min(min, dp[i - num * num] + 1);
                num++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public int numSquares2(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);   /* 在-1²,2²,3², 4²,5² ... x²<=n 种子问题之间选择最小的步数 */
            }
        }
        return dp[n];
    }
}