package com.janhen.coding.leetcode.ds.array.solution4;

class Solution {
  // time: O(log(m + n)), space: O(1)
  public double findMedianSortedArrays(int[] A, int[] B) {
    int len = A.length + B.length;
    return (findKth(A, 0, B, 0, (len + 1) / 2) + findKth(A, 0, B, 0, (len + 2) / 2)) / 2.0;
  }

  //  A ---------------
  //             ^
  //            aL
  //  B ---------^-----
  //
  public double findKth(int[] A, int aL, int[] B, int bL, int k) {
    // case0.1: find in only one array, A OR B special
    if (aL >= A.length)
      return B[bL + k - 1];  // find kth in B[bL, B.length - 1]
    if (bL >= B.length)
      return A[aL + k - 1];
    // case0.2: only find first element, k special
    if (k == 1)
      return Math.min(A[aL], B[bL]);

    // get A and B array k/2th element
    int aMid = aL + k / 2 - 1 < A.length ? A[aL + k / 2 - 1] : Integer.MAX_VALUE;
    int bMid = bL + k / 2 - 1 < B.length ? B[bL + k / 2 - 1] : Integer.MAX_VALUE;

    // 确定在 A 的右边还是 B 的右边
    // find in small data set (-k/2), k - k/2 保证在 k 为奇数的情况下...
    if (aMid <= bMid) {
      // skip A left narrow k/2, find in A right, B all
      return findKth(A, aL + k / 2, B, bL, k - k / 2);
    } else {
      // skip B left narrow k/2, find in A all, B right
      return findKth(A, aL, B, bL + k / 2, k - k / 2);
    }
  }
}