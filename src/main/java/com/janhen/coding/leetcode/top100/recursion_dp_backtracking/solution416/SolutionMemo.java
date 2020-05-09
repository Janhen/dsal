package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution416;

// 416. Partition Equal Subset Sum
//https://leetcode.com/problems/partition-equal-subset-sum/description/
// medium
// dp

/*
 只包含正数
 Given a non-empty array containing only positive integers,
 find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.*/

// 处理索引为负数情况无效
class SolutionMemo {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        memo = new int[nums.length+1][sum + 1];
        return canPartition(nums, 0, sum);
    }

    private boolean canPartition(int[] nums, int index, int sum) {
        if (index == nums.length)
            return sum == 0;
        if (sum < 0) {
            return false;
        }
        if (memo[index][sum] != 0)
            return memo[index][sum] == 1;
        boolean canPart = canPartition(nums, index + 1, sum) || canPartition(nums, index + 1, sum - nums[index]);
        memo[index][sum] = canPart ? 1 : -1;
        return canPart;
    }
}
