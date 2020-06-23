package com.janhen.coding.leetcode.ds.array.solution84;

import java.util.Stack;

class Solution2 {
  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    // Create an empty stack. The stack holds indexes of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    for (int i = 0; i <= len; i++){
      int height = (i == len ? 0 : heights[i]);
      if (stack.isEmpty() || height >= heights[stack.peek()]) {
        // init or bigger to push index
        stack.push(i);
      } else {
        int topIndex = stack.pop();
        maxArea = Math.max(maxArea, heights[topIndex] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
        i--;
      }
    }
    return maxArea;
  }


  public static void main(String[] args) {
    int[] heights = {
        2, 1, 5, 6, 2, 3 };
    new Solution2().largestRectangleArea(heights);
  }
}