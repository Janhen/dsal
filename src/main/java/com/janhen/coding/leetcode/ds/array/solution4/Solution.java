package com.janhen.coding.leetcode.ds.array.solution4;

class Solution {
  // time: O(log(m + n)), space: O(1)
  public double findMedianSortedArrays(int[] A, int[] B) {
    int len = A.length + B.length;
    return (findKth(A, 0, B, 0, (len + 1) / 2) + findKth(A, 0, B, 0, (len + 2) / 2)) / 2.0;
  }

  public double findKth(int[] A, int aL, int[] B, int bL, int k) {
    // pre-process input value, special value handle
    assert A.length - aL + B.length - bL >= k;
    if (aL >= A.length)
      return B[bL + k - 1];
    if (bL >= B.length)
      return A[aL + k - 1];
    if (k == 1)
      return Math.min(A[aL], B[bL]);

    int aMid = aL + k / 2 - 1 < A.length ? A[aL + k / 2 - 1] :Integer.MAX_VALUE;
    int bMid = bL + k / 2 - 1 < B.length ? B[bL + k / 2 - 1] : Integer.MAX_VALUE;
    if (aMid <= bMid) {
      // skip A left narrow k/2, find in A right, B all
      return findKth(A, aL + k / 2, B, bL, k - k / 2);
    }
    else {
      // skip B left narrow k/2, find in A all, B right
      return findKth(A, aL, B, bL + k / 2, k - k / 2);
    }
  }
}