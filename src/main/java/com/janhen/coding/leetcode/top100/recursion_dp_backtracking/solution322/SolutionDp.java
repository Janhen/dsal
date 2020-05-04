package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution322;

import java.util.Arrays;

class SolutionDp {

    // 可多次使用背包中的物品使得总容量必须为 amount
    // 每一种 amount 都使用所有可能的硬币进行尝试
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;                  // when capacity is 0, then no coin to put in backpack
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i ++) {   // make sure in i capacity
            for (int j = 0; j < coins.length; j ++) {    // whether or not put coins[i] in backpack
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}