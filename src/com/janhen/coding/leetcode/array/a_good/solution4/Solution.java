package com.janhen.leetcode.array.a_good.solution4;

class Solution {
    // todo QQ
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    // [aL, len1)             [bL, len2)
    public double getkth(int[] A, int aL, int[] B, int bL, int k) {
        if (aL > A.length - 1) return B[bL + k - 1];
        if (bL > B.length - 1) return A[aL + k - 1];
        if (k == 1) return Math.min(A[aL], B[bL]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aL + k/2 - 1 < A.length) aMid = A[aL + k/2 - 1];
        if (bL + k/2 - 1 < B.length) bMid = B[bL + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aL + k/2, B, bL,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aL,       B, bL + k/2, k - k/2);// Check: bRight + aLeft
    }
}