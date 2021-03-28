package com.janhen.coding.leetcode.ds.stackqueue.sm_nested_ugly_diff_polish_decode_next.solution150;

import java.util.Stack;

class Solution {
  // stack storage is reversed
  public int evalRPN(String[] tokens) {
    // 1. collect result
    Stack<Integer> stack = new Stack<>();
    int num1 = 0, num2 = 0, val = 0;
    for (String str : tokens) {
      switch (str) {
        case "+":
          num1 = stack.pop();
          num2 = stack.pop();
          val = num2 + num1;
          stack.push(val);
          break;
        case "-":
          num1 = stack.pop();
          num2 = stack.pop();
          val = num2 - num1;
          stack.push(val);
          break;
        case "*":
          num1 = stack.pop();
          num2 = stack.pop();
          val = num2 * num1;
          stack.push(val);
          break;
        case "/":
          num1 = stack.pop();
          num2 = stack.pop();
          val = num2 / num1;        // first nums2 then nums1
          stack.push(val);
          break;
        default:
          stack.push(Integer.valueOf(str));
          break;
      }
    }
    // 2. handle result
    if (stack.isEmpty())
      return val;
    else if (stack.size() == 1)
      return stack.pop();
    else
      throw new IllegalArgumentException();
  }
}