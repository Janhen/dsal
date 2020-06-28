package com.janhen.coding.leetcode.ds.array.binarysearch.solution278;

public class Solution extends VersionControl {
  // 当前版本基于前一个版本
  // 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；
  // 否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
  // 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
  public int firstBadVersion(int n) {
    int lo = 0, hi = n;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid))
        hi = mid;
      else
        lo = mid + 1;
    }
    return lo;
  }
}