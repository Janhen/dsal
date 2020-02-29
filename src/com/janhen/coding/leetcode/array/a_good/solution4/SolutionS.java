package com.janhen.leetcode.array.a_good.solution4;

/*
 * 先归并一半的数组，之后取出中位数
 * 26 ms, faster than 89.58%
 */
class SolutionS {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int[] nums = new int[len/2+1];
        int i = 0, j = 0, k = 0;
        for (; k < len && k < len/2+1; k ++) {
            if (i >= len1)
                nums[k] = nums2[j ++];
            else if (j >= len2)
                nums[k] = nums1[i ++];
            else if (nums1[i] < nums2[j])
                nums[k] = nums1[i ++];
            else
                nums[k] = nums2[j ++];
        }
        if (len % 2== 0)
            return ((double) nums[nums.length - 1] + (double) nums[nums.length-2]) / 2;
        else
            return nums[nums.length-1];
    }
}