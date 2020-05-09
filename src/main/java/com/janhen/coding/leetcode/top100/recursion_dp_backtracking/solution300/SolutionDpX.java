package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution300;

// 以上解法的时间复杂度为 O(N2)，

import java.util.Arrays;

/*
 * 已知一个序列 {S1, S2,...,Sn}，取出若干数组成新的序列 {Si1, Si2,..., Sim}，其中 i1、i2 ... im 保持递增，
 *
 * 即新序列中各个数仍然保持原数列中的先后顺序，称新序列为原序列的一个 子序列 。
 *
 * 如果在子序列中，当下标 ix > iy 时，Six > Siy，称子序列为原序列的一个 递增子序列 。
 *
 * 定义一个数组 dp 存储最长递增子序列的长度，dp[n] 表示以 Sn 结尾的序列的最长递增子序列长度。
 *
 * 对于一个递增子序列 {Si1, Si2,...,Sim}，
 *
 * 如果 im < n 并且 Sim < Sn，此时 {Si1, Si2,..., Sim, Sn} 为一个递增子序列，递增子序列的长度增加 1。
 *
 * 满足上述条件的递增子序列中，长度最长的那个递增子序列就是要找的，
 *
 * 在长度最长的递增子序列上加上 Sn 就构成了以 Sn 为结尾的最长递增子序列。
 *
 * 因此 dp[n] = max{ dp[i]+1 | Si < Sn && i < n} 。
 *
 * 因为在求 dp[n] 时可能无法找到一个满足条件的递增子序列，此时 {Sn} 就构成了递增子序列，需要对前面的求解方程做修改，令 dp[n] 最小为 1，即：
 *
 * <div align="center"><img src="https://latex.codecogs.com/gif.latex?dp[n]=max\{1,dp[i]+1|S_i<S_n\&\&i<n\}"/></div> <br>
 *
 *
 * 对于一个长度为 N 的序列，最长递增子序列并不一定会以 SN 为结尾，因此 dp[N] 不是序列的最长递增子序列的长度，
 *
 * 需要遍历 dp 数组找出最大值才是所要的结果，max{ dp[i] | 1 <= i <= N} 即为所求。
 */
public class SolutionDpX {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {
            int max = 1;                          // mean [i,i] as one sequence
            for (int j = 0; j < i; j ++)
                max = Math.max(max, dp[j] + 1);
            dp[i] = max;
        }
         return Arrays.stream(dp).max().orElse(0);        // need take result from dp array
    }
}
//int ret = 0;
//        for (int i = 0; i < n; i++) {
//            ret = Math.max(ret, dp[i]);
//        }
//        return ret;

