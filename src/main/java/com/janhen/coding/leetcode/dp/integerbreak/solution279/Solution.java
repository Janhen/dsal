package com.janhen.coding.leetcode.dp.integerbreak.solution279;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {       // find in square in order
                if (square > i)
                    break;
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    // generate all square number <= n
//    private List<Integer> generateSquareList(int n) {
//        List<Integer> squareList = new ArrayList<>();
//        int num = 1;
//        int square = 1;
//        while (square <= n) {
//            squareList.add(square);
//            num ++;
//            square = num * num;
//        }
//        return squareList;
//    }
    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }
}