package com.janhen.leetcode.dp.base.knapsack01;

public class  SolutionDP3 {

    // time : O(n*C)
    // space : O(C)
    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        int[] memo = new int[C + 1];

        for (int j = 0; j <= C; j ++)
            memo[j] = (j >= w[0] ? v[0] : 0);

        for (int i = 0; i < n; i ++)            /* 表示当前计算的是第 [i] 行放入物品的最大值 */
            for (int j = C; j >= w[i]; j --)   // 反向操作, 防止覆盖, 原来值为 [i-1] 物品所对应的物品最大值  [j-w[i]]
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);   // when current capacity < current value can terminate in advance.

        return memo[C];
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(new SolutionDP3().knapsack01(c, p, bag));
    }
}
/*public int knapsack01(int[] w, int[] v, int C) {

    int n = w.length;
    int[] memo = new int[C + 1];

    for (int j = 0; j <= C; j ++)
        memo[j] = (j >= w[0] ? v[0] : 0);

    for (int i = 0; i < n; i ++)
        for (int j = C; j >= 0; j --) {
            // up
            memo[j] = memo[j];
            if (j >= w[i])
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);  // left
        }

    return memo[C];
}*/