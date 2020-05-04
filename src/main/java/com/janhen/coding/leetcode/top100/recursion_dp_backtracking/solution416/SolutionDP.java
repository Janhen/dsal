package main.java.janhen.leetcode.top100.recursion_dp_backtracking.solution416;

class SolutionDP {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        int n = nums.length;
        int C = sum / 2;
        boolean[][] dp = new boolean[n][C+ 1];    // knapsack 01
        for (int i = 0; i <= C; i ++)        // [0] 号物品是否可以放入到背包中
            dp[0][i] = (nums[0] == i);
        for (int i = 1; i < n; i ++)
            for (int j = 1; j <= C; j ++) {
                if (j >= nums[i]) dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                else dp[i][j] = dp[i-1][j];
            }
        return dp[n-1][C];
    }
}
