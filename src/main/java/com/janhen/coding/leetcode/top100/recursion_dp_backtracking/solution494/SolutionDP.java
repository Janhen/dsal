package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution494;

import java.util.Arrays;

/*
 * 该问题可以转换为 Subset Sum 问题，从而使用 0-1 背包的方法来求解。
 *
 * 可以将这组数看成两部分，P 和 N，其中 P 使用正号，N 使用负号，有以下推导：
 *
 *                   sum(P) - sum(N) = target
 * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
 *                        2 * sum(P) = target + sum(nums)
 * 因此只要找到一个子集，令它们都取正号，并且和等于 (target + sum(nums))/2，就证明存在解。
 */
class SolutionDP {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        if (sum < S || (sum + S) % 2 == 1) {      // handle exception conditon
            return 0;
        }
        int C = (sum + S) / 2;
        int[] dp = new int[C + 1];
        dp[0] = 1;                                    // 代表在所要求的总和为 i 的情况下, 数组中的个数
        for (int i = 0; i < nums.length; i ++) {
            for (int j = C; j >= 0; j --) {
                if (j >= nums[i])
                    dp[j] = dp[j] + dp[j-nums[i]];        // default dp[j] = dp[j] 及不讲当前 [i] 放入的可能数量
            }
        }
        return dp[C];
    }
}