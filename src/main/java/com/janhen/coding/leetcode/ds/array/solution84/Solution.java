package com.janhen.coding.leetcode.ds.array.solution84;

import java.util.Stack;

class Solution {
  // 单调栈
  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    for (int i = 0; i <= len; i++) {
      // 尾部截断
      int height = (i == len ? 0 : heights[i]);
      if (stack.isEmpty() || height >= heights[stack.peek()]) {
        // init or bigger to push index
        stack.push(i);
      } else {
        int topIdx = stack.pop();
        int width = stack.isEmpty() ? i : i - 1 - stack.peek();
        maxArea = Math.max(maxArea, heights[topIdx] * width);
        i--;
      }
    }
    return maxArea;
  }
}