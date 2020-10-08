package com.janhen.coding.leetcode.ds.array.solution84;

import java.util.Stack;

class Solution2 {
  // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
  public int largestRectangleArea(int[] heights) {
    // Create an empty stack. The stack holds indexes of hist [] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    Stack<Integer> stack = new Stack<>();

    int max_area = 0; // Initialize max area
    int tp;  // To store top of stack
    int area_with_top; // To store area with top bar as the smallest bar

    // Run through all bars of given histogram
    int i = 0;
    while (i < heights.length) {
      // If this bar is higher than the bar on top stack, push it to stack
      if (stack.empty() || heights[stack.peek()] <= heights[i])
        stack.push(i++);

        // If this bar is lower than top of stack, then calculate area of rectangle
        // with stack top as the smallest (or minimum height) bar. 'i' is
        // 'right index' for the top and element before top in stack is 'left index'
      else {
        tp = stack.peek();  // store the top index
        stack.pop();  // pop the top

        // Calculate the area with hist[tp] stack as smallest bar
        area_with_top = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);

        // update max area, if needed
        if (max_area < area_with_top)
          max_area = area_with_top;
      }
    }

    // Now pop the remaining bars from stack and calculate area with every
    // popped bar as the smallest bar
    while (stack.empty() == false) {
      tp = stack.peek();
      stack.pop();
      area_with_top = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);

      if (max_area < area_with_top)
        max_area = area_with_top;
    }

    return max_area;

  }


  public static void main(String[] args) {
    int[] heights = {
      2, 1, 5, 6, 2, 3};
    new Solution2().largestRectangleArea(heights);
  }
}