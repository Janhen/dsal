package com.janhen.coding.swordoffer.other.problem63;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 按时间累计的最小价值，尝试在此刻进行卖出，不断比较最大收益
        int curMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i ++) {
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }
        return maxProfit;
    }
}
