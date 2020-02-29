package com.janhen.leetcode.top100.recursion_dp_backtracking.bfs.solution279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionDP2 {
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
    // 40 ms, faster than 46.63%
    //
    public int numSquares(int n) {
        List<Integer> squareList = geneSquareList(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int square : squareList) {
                if (square > i) break;
                dp[i] = Math.min(dp[i], dp[i-square] + 1);
            }
        }
        return dp[n];
    }

    private List<Integer> geneSquareList(int n) {
        List<Integer> res = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            res.add(square);
            square += diff;
            diff += 2;
        }
        return res;
    }


    public int numSquares2(int n) {
        List<Integer> squareList = geneSquareList(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) break;
                min = Math.min(min, dp[i-square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}