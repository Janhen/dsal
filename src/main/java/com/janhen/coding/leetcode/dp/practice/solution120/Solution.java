package com.janhen.coding.leetcode.dp.practice.solution120;

import java.util.List;

class Solution {
    // 由下到上逐渐填充, 每个节点都有向左和向右两个可能的路径, 选择最小的值
    // 7 ms, faster than 85.42%
    // minpath[k][i] = min{minpath[k+1][i], minpath[k+1][i+1]} + triangle[k][i]
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i ++)
            dp[m-1][i] = triangle.get(m-1).get(i);

        for (int i = m - 2; i >= 0; i --) {   // last 2th row
            for (int j = 0; j < i+1; j ++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);          /* 当前节点值 + 可选的两个下层节点中的最小值 */
            }
        }
        return dp[0][0];
    }
}