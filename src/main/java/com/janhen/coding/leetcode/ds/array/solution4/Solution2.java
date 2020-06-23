package com.janhen.coding.leetcode.ds.array.solution4;

class Solution2 {
  /*
  数组 + 比较进行排序， 先归并一半的数组，之后取出中位数
  mock sort half elements use array and compare
  time: O(log(m + n)), space: O(n)
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int len = len1 + len2;
    int[] nums = new int[len / 2 + 1];
    // i,j as iterate point,  k to find
    int i = 0, j = 0, k = 0;
    for (; k < len && k < len / 2 + 1; k++) {
      if (i >= len1)
        nums[k] = nums2[j++];
      else if (j >= len2)
        nums[k] = nums1[i++];
      else if (nums1[i] < nums2[j])
        nums[k] = nums1[i++];
      else
        nums[k] = nums2[j++];
    }
    if (len % 2 == 0)
      return ((double) nums[nums.length - 1] + (double) nums[nums.length - 2]) / 2;
    else
      return nums[nums.length - 1];
  }
}