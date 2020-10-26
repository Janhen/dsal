package com.janhen.coding.leetcode.ds.array.solution718;

public class Solution {

  public int findLength(int[] A, int[] B) {
    int len1 = A.length;
    int len2 = B.length;
    int ret = 0;
    for (int i = 0; i < len1; i++) {
      int len = Math.min(len1 - i, len2);
      int maxLen = maxLen(A, B, i, 0, len);
      ret = Math.max(ret, maxLen);
    }
    for (int i = 0; i < len2; i++) {
      int len = Math.min(len2 - i, len1);
      int maxLen = maxLen(A, B, 0, i, len);
      ret = Math.max(ret, maxLen);
    }
    return ret;
  }

  private int maxLen(int[] A, int[] B, int beginA, int beginB, int len) {
    int ret = 0;
    int k = 0;
    for (int i = 0; i < len; i++) {
      if (A[beginA + i] == B[beginB + i]) {
        k++;
      } else {
        k = 0;
      }
      ret = Math.max(ret, k);
    }
    return ret;
  }
}
