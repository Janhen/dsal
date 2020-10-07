package com.janhen.coding.leetcode.ds.array.solution4;

class Solution2 {
  //  time: O(log(m + n)), space: O(n)
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int len = len1 + len2;
    int[] nums = new int[(len + 2) / 2];
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
    return (nums[(len + 1) / 2 - 1] + nums[(len + 2) / 2 - 1]) / 2.0;
  }
}