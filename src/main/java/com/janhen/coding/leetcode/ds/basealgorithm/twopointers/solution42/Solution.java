package com.janhen.coding.leetcode.ds.basealgorithm.twopointers.solution42;

class Solution {
  /*
 think it in a cumulative way
 sum water amount of each bin(width=1)

 Search from left to right and maintain a max height of left and right separately,
 which is like a one-side wall of partial container. Fix the higher one and flow water
 from the lower part. For example, if current height of left is lower,
 we fill water in the left bin. Until left meets right, we filled the whole container.
  */
  public int trap(int[] height) {
    int L = 0;
    int R = height.length - 1;

    int res = 0;
    int maxL = 0, maxR = 0;
    while (L <= R) {
      int lNum = height[L];
      int rNum = height[R];

      maxL = Math.max(maxL, lNum);
      maxR = Math.max(maxR, rNum);

      if (lNum < rNum) {
        res += maxL - lNum;
        L++;
      } else {
        res += maxR - rNum;
        R--;
      }
    }
    return res;
  }
}