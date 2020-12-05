package com.janhen.coding.leetcode.ds.array.solution718;

public class Solution {

  // O(n^2)
  // TOOPT
  public int findLength(int[] A, int[] B) {
    int len1 = A.length;
    int len2 = B.length;
    int ret = 0;
    // 从数组 A 在 B 中匹配查找
    for (int i = 0; i < len1; i++) {
      int len = Math.min(len1 - i, len2);
      int maxLen = maxLen(A, B, i, 0, len);
      ret = Math.max(ret, maxLen);
    }
    // 从数组 B 在 A 中匹配查找
    for (int i = 0; i < len2; i++) {
      int len = Math.min(len2 - i, len1);
      int maxLen = maxLen(A, B, 0, i, len);
      ret = Math.max(ret, maxLen);
    }
    return ret;
  }

  // 找 A[beginA, beginA+len], B[beginB, beginB+len] 中公共的最长子数组长度
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
