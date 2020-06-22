package com.janhen.coding.leetcode.algs.dp.practice.solution120;

import java.util.List;

class Solution1 {
    // todo Q
    // 6 ms, faster than 96.40%
    // minpath[k][i] = min{minpath[k+1][i], minpath[k+1][i+1]} + triangle[k][i]
    //     in kth level
    //     minpath[i] = min{minpath[i], minpath[i+1]} + triangle[k][i];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size()-1).size();
        int[] dp = new int[n+1];
        for (int i = n - 1; i >= 0; i --) {
            for (int j = 0; j < i+1; j ++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

}