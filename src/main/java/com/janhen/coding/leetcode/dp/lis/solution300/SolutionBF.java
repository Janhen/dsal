package com.janhen.coding.leetcode.dp.lis.solution300;

import java.util.Arrays;

/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class SolutionBF {

    private int[] memo;

    // all recursiont_dp ⇒ sub recursiont_dp to merge
    // all array ⇒ sub array
    // [0...n-1]  ⇒  [0...index-1]
    public int lengthOfLIS(int[] nums) {            /* 求解∀可能中最大问题 */
        if(nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for(int i = 0 ; i < nums.length ; i ++)
            res = Math.max(res, getMaxLength(nums, i));
        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index){
        if(memo[index] != -1)
            return memo[index];
        int res = 1;
        for(int i = 0 ; i < index; i ++)
            if(nums[index] > nums[i])
                res = Math.max(res, 1 + getMaxLength(nums, i));
        return memo[index] = res;
    }

    public static void main(String[] args) {

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new SolutionBF()).lengthOfLIS(nums1));
        // 4

        // ---

        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println((new SolutionBF()).lengthOfLIS(nums2));
        // 3

        // ---

        int nums3[] = {2, 2};
        System.out.println((new SolutionBF()).lengthOfLIS(nums3));
        // 1

        // ---

        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new SolutionBF()).lengthOfLIS(nums4));
        // 6  [1,3,6,7,9,10]
    }
}
