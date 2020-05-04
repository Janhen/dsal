package main.java.janhen.swordoffer.other.problem63;

public class Solution_my {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int curMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i ++) {
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);     // in [i] to sell, and in curMin position to buy
        }
        return maxProfit;
    }
}
