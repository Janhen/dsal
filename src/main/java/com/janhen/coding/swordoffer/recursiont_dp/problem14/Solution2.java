package main.java.janhen.swordoffer.recursiont_dp.problem14;

// 14 减绳子
// 动态规划的特性：
//  可分解为子问题，
//  子问题能合成最钟解
//  最优子结构性质
//  子问题具有重合

//动态规划的特性：
//  - 可分解为子问题
//  - 子问题可合成最终解
//  - 子问题具有重合
//  - 自上向下分析问题，自下向上解决问题

//分析：
//使用 f(n) 代表长度为 n 的绳子被剪成若干段之后相乘的最大值，包含了不减的情况；
//减第一刀的时候，有 n - 1 种可能，分别在长度为 1, 2, 3, ... , n - 1 处切断；
//因而有 递归公式 ：  f(n) = max(f(1)*f(n-1), f(2)*f(n-2), f(3)*f(n-3), ...) = max( f(i) * f(n - i) )     ( 0 < i < n)
//
// 因此大问题可以分解成小问题，并且同剪绳子问题，大问题的最优解包括小问题的最优解，那么可以求出小问题的最优解，存到数组中，
// 在求大问题最优解时就可以直接从数组中获取，最终获得最优解
public class Solution2 {
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++)         // 相乘的对称性
                max = Math.max(max, dp[j] * dp[i - j]);
            dp[i] = max;
        }
        return dp[n];
    }
}
