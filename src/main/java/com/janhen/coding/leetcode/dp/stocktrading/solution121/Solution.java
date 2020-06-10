package com.janhen.coding.leetcode.dp.stocktrading.solution121;

public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0)
      return 0;
    int curMin = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      curMin = Math.min(curMin, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - curMin);
    }
    return maxProfit;
  }
}
