package com.janhen.coding.leetcode.algs.dp.knapsack.solution139;

import java.util.List;

// todo Q
public class SolutionDPX {
    // dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。
    //
    //0-1 背包和完全背包在实现上的不同之处是，0-1 背包对物品的迭代是在最外层，而完全背包对物品的迭代是在最里层。
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {   // 完全一个物品可以使用多次
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
