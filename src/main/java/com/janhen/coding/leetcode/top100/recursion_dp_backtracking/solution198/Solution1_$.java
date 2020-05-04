package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution198;

/// 198. House Robber
/// https://leetcode.com/problems/house-robber/description/
/// 动态规划, 优化状态转移
/// 时间复杂度: O(n)
/// 空间复杂度: O(n)

// memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
// 或者当前房子放弃, 从下一个房子开始考虑
// 或者抢劫当前的房子, 从i+2以后的房子开始考虑
public class Solution1_$ {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i --)
            dp[i] = Math.max(dp[i + 1], nums[i] + (i + 2 < n ? dp[i + 2] : 0));

        return dp[0];
    }

    public static void main(String[] args) {

        int nums[] = {2, 1};
        System.out.println((new Solution1_$()).rob(nums));
    }
}
