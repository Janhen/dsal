package com.janhen.coding.leetcode.algs.dp.knapsack.solution322;

/*题目描述：给一些面额的硬币，要求用这些硬币来组成给定面额的钱数，并且使得硬币数量最少。硬币可以重复使用。

- 物品：硬币
- 物品大小：面额
- 物品价值：数量

因为硬币可以重复使用，因此这是一个完全背包问题。
*/
class SolutionBF {

    // 可多次使用背包中的物品使得总容量必须为 amount
    // 每一种 amount 都使用所有可能的硬币进行尝试
    public int coinChange(int[] coins, int amount) {
        return help(coins, amount);
    }

    private int help(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i ++) {
            int cur = help(coins, amount - coins[i]);     // condition is i
            if (cur >= 0)
                res = Math.min(cur + 1, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println((new SolutionBF()).coinChange(new int[]{1,2,5}, 11));
    }
}