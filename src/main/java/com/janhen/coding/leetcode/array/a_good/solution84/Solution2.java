package com.janhen.coding.leetcode.array.a_good.solution84;

import java.util.Stack;

class Solution2 {
  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    // Create an empty stack. The stack holds indexes of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    Stack<Integer> s = new Stack<>();
    int maxArea = 0;
    for (int i = 0; i <= len; i++){
      int height = (i == len ? 0 : heights[i]);
      if (s.isEmpty() || height >= heights[s.peek()]) {
        // init or bigger to push index
        s.push(i);
      } else {
        int topIndex = s.pop();
        maxArea = Math.max(maxArea, heights[topIndex] * (s.isEmpty() ? i : i - 1 - s.peek()));
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