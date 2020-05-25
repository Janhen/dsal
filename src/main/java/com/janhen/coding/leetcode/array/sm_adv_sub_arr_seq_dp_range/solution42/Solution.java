package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution42;

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
    int left = 0;
    int right = height.length - 1;
    int res = 0;
    int maxleft = 0, maxright = 0;
    while (left <= right) {

      maxleft = Math.max(maxleft, height[left]);
      maxright = Math.max(maxright, height[right]);

      if (height[left] < height[right]) {
        res += maxleft - height[left];
        left++;
      } else {
        res += maxright - height[right];
        right--;
      }
    }
    return res;
  }
}