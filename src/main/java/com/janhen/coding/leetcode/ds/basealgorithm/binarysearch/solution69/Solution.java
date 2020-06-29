package com.janhen.coding.leetcode.ds.basealgorithm.binarysearch.solution69;

class Solution {
  public int mySqrt(int x) {
    if (x <= 1)
      return x;
    //   sqrt * sqrt = x
    // ⇒ sqrt=x/sqrt
    // ⇒ find sqrt
    int lo = 1, hi = x;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int sqrt = x / mid;
      if (sqrt == mid)
        return mid;
      else if (sqrt < mid)
        hi = mid - 1;
      else
        lo = mid + 1;
    }
    return hi;
  }
}