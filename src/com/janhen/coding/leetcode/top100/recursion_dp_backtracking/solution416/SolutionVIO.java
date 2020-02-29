package com.janhen.leetcode.top100.recursion_dp_backtracking.solution416;

// 416. Partition Equal Subset Sum
//https://leetcode.com/problems/partition-equal-subset-sum/description/
// medium
// dp

/* Given a non-empty array containing only positive integers,
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

class SolutionVIO {
    // 问题转换成找到部分数组子序列实现总和为 sum/2
    public boolean canPartition(int[] nums) {
        // input check
        int sum = 0;
        for (int i = 0; i < nums.length; i ++)
            sum += nums[i];
        if (sum % 2 != 0)  // only even number can partition
            return false;
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    // __ __ __ __ __ __
    //          FT FT FT    每个位置两种可能    共 2^n 种可能
    // reverse operation
    // 从 [i ... len-1] 中元素是否  ∃ sum(subsequence) == sum
    private boolean tryPartition(int[] nums, int index, int sum) {       /* 两个参数控制递归,唯一确定结果 ⇒ 构造二维表,记录各种可能性 */        /* 通过参数 index 控制数组中对应位置, 参数 sum 控制是否需要以及异常情况的终止以及正确结果的返回 */
        if (sum == 0)
            return true;
        if (sum < 0 || index < 0)
            return false;
        return tryPartition(nums, index - 1, sum) ||      // not include current element
                tryPartition(nums, index - 1, sum - nums[index]);    // include current element            /* f || g || s || r  来代表各种可能性 */
    }
}
