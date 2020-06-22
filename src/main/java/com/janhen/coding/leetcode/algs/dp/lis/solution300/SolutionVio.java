package com.janhen.coding.leetcode.algs.dp.lis.solution300;

// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/description/
// medium
// binary search, dp

//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//Example:
//
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Note:
//
//There may be more than one LIS combination, it is only necessary for you to return the length.
//Your algorithm should run in O(n2) complexity.
//Follow up: Could you improve it to O(n log n) time complexity?

/// 记忆化搜索
/// 时间复杂度: O(n^2)
/// 空间复杂度: O(n)
public class SolutionVio {

    // all recursiont_dp ⇒ sub recursiont_dp to merge
    // all array ⇒ sub array
    // [0...n-1]  ⇒  [0...index-1]
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = 1;
        for(int i = 0 ; i < nums.length ; i ++)
            res = Math.max(res, getMaxLength(nums, i));
        return res;
    }

    // 以 nums[index] 为结尾的最长上升子序列的长度
    private int getMaxLength(int[] nums, int index){
        if (index == nums.length) {
            System.out.println("Terminate");
            return 0;
        }
        System.out.println(String.format("index: %d, value: %d", index, nums[index]));
        int res = 1;
        for(int i = 0 ; i <= index-1 ; i ++) {
            if(nums[index] > nums[i]) {    // 找出以 [i] 开始以 [index] 为结尾子数组中最长的递增序列
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }
        System.out.println(String.format("res: %d", res));
        return res;
    }

    public static void main(String[] args) {

        int nums1[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new SolutionVio()).lengthOfLIS(nums1));
        // 4 [2,3,7,101]

        // ---

        System.out.println("---------");
        int nums2[] = {4, 10, 4, 3, 8, 9};
        System.out.println((new SolutionVio()).lengthOfLIS(nums2));
        // 3  [ 3, 8, 9]

        // ---

        System.out.println("---------");
        int nums3[] = {2, 2};
        System.out.println((new SolutionVio()).lengthOfLIS(nums3));
        // 1

        // ---

        System.out.println("---------");
        int nums4[] = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new SolutionVio()).lengthOfLIS(nums4));
        // 6
    }
}
