package com.janhen.coding.leetcode.ds.array.solution84;

class SolutionB {
  public static void main(String[] args) {
    int[] heights = {
      2, 1, 5, 6, 2, 3};
    new SolutionB().largestRectangleArea(heights);
  }

  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      maxArea = Math.max(maxArea, findMaxAreaFromBegin(heights, i));
    }
    return maxArea;
  }

  // 以 nums[begin] 高度向左右扩散的面积
  public int findMaxAreaFromBegin(int[] nums, int begin) {
    int height = nums[begin];

    int rightIdx = begin;
    for (int i = begin + 1; i < nums.length; i++) {
      int curHeight = nums[i];
      if (curHeight >= height) {
        rightIdx = i;
      } else {
        break;
      }
    }

    int leftIdx = begin;
    for (int i = begin - 1; i >= 0; i--) {
      int curHeight = nums[i];
      if (curHeight >= height) {
        leftIdx = i;
      } else {
        break;
      }
    }
    return (rightIdx - leftIdx + 1) * height;
  }
}