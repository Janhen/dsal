package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution309;

class Solution {
    // 状态机
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[] s0 = new int[n];   // can buy    在卖了一次之后的后天之后进入
        int[] s1 = new int[n];   // can sell  可由买股票进入， OR 当前选择观望等待最好的时机
        int[] s2 = new int[n];   // rest     休息为强制休息, 只能因为刚刚卖掉进入该状态, 之后休息进入 can buy 状态
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i ++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s0[i-1] - prices[i], s2[i-1]);
            s2[i] = Math.max(s1[i-1] + prices[i], s2[i-1]);
        }
        return Math.max(s0[n-1], s2[n-1]);
    }
}