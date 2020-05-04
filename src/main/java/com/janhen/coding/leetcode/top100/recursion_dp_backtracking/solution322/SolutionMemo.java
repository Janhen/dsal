package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution322;

// 322. Coin Change
//https://leetcode.com/problems/coin-change/

/*

Medium

1340

65

Favorite

Share
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
 */

// 27 ms, faster than 41.60%
class SolutionMemo {

    // 可多次使用背包中的物品使得总容量必须为 amount
    // 每一种 amount 都使用所有可能的硬币进行尝试
    public int coinChange(int[] coins, int amount) {

        return help(coins, amount, new int[amount+1]);
    }

    private int help(int[] coins, int amount, int[] memo) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (memo[amount] != 0)
            return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++) {                     /* 经典DP, 每次都使用对应的各种面值进行尝试, 隐含处理了重复的情况 */
            int cur = help(coins, amount - coins[i], memo);
            if (cur >= 0)
                res = Math.min(cur + 1, res);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;             /* 判断是否可以组合 */
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionMemo()).coinChange(new int[]{1,2,5}, 11));
    }
}