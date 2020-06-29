package com.janhen.coding.leetcode.ds.array.solution4;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution2$ {
  /*
  优先队列排序
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length, len2 = nums2.length;
    int len = len1 + len2;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    int i = 0, j = 0, k = 0;
    for (; k < len && k < len / 2 + 1; k++) {
      if (i >= len1)
        pq.offer(nums2[j++]);
      else if (j >= len2)
        pq.offer(nums1[i++]);
      else if (nums1[i] < nums2[j])
        pq.offer(nums1[i++]);
      else
        pq.offer(nums2[j++]);
    }
    if (len % 2 == 0) {
      return ((double) pq.poll() + (double) pq.poll()) / 2;
    } else {
      return pq.poll();
    }
  }
}