package com.janhen.coding.leetcode.algs.dp.knapsack;

/*
有一个背包，它的容量为C(Capacity)，。现在有n种不同的品，
编号为 0...n-1，其中每一件物品的重量为w（i），价值为v（i）。问可以
向这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物
品的总价值最大。

⇒  从 n 个物品中选取 有限种物品，满足容量限制 ，同时希望价值最大   ⇒  组合问题
 */
public class SolutionBF {

    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        return bestValue(w, v, n - 1, C);
    }

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;
        int excludeSelf = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            int includeSelf = v[index] + bestValue(w, v, index - 1, c - w[index]);
            return Math.max(includeSelf, excludeSelf);
        } else {
            return excludeSelf;
        }
    }

    public static void main(String[] args) {
        int[] c = { 3, 2, 4, 7 };
        int[] p = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(new SolutionBF().knapsack01(c, p, bag));
    }
}
