package com.janhen.coding.leetcode.ds.array.solution4;

class Solution {
  /*
   * time: O(log(m + n)), space: O(1)
   */
  public double findMedianSortedArrays(int[] A, int[] B) {
    int len = A.length + B.length;
    // 求解中位数问题的表达式
    // ((len + 1) / 2 + (len + 2) / 2) / 2
    //  len  odd number
    return (getKth(A, 0, B, 0, (len + 1) / 2) + getKth(A, 0, B, 0, (len + 2) / 2)) / 2.0;
  }

  // find two array kth biggest number
  // A[aL, len1) B[bL, len2)
  public double getKth(int[] A, int aL, int[] B, int bL, int k) {
    // handle tail border
    if (aL >= A.length)
      return B[bL + k - 1];
    if (bL >= B.length)
      return A[aL + k - 1];
    // handle head border
    if (k == 1)
      return Math.min(A[aL], B[bL]);

    int aMid = Integer.MAX_VALUE;
    int bMid = Integer.MAX_VALUE;
    if (aL + k / 2 - 1 < A.length)
      aMid = A[aL + k / 2 - 1];
    if (bL + k / 2 - 1 < B.length)
      bMid = B[bL + k / 2 - 1];

    // TODO Q
    if (aMid <= bMid)
      // half size
      return getKth(A, aL + k / 2, B, bL, k - k / 2);// Check: aRight + bLeft
    else
      return getKth(A, aL, B, bL + k / 2, k - k / 2);// Check: bRight + aLeft
  }
}