package com.janhen.coding.leetcode.array.sm_adv_sub_arr_seq_dp_range.solution42;

class Solution2 {
  public int trap(int[] height) {
    if (height.length < 3) return 0;
    int tallestIdx = 0;
    // to eliminate index 0
    for (int i = 1; i < height.length; i++)
      if (height[tallestIdx] < height[i]) tallestIdx = i;

    int water = 0;
    for (int i = 0, tall = 0; i < tallestIdx; i++) {
      if (tall < height[i]) tall = height[i];
      else water += tall - height[i];
    }
    for (int i = height.length - 1, tall = 0; i > tallestIdx; i--) {
      if (tall < height[i]) tall = height[i];
      else water += tall - height[i];
    }
    return water;
  }
}