package com.janhen.coding.leetcode.ds.stackqueue.sm_nested_ugly_diff_polish_decode_next.solution150;

import java.util.Deque;
import java.util.LinkedList;

class SolutionRef {
  // 类似 Dijkstra 双栈表达式算法
  // 7 ms, faster than 75.62%
  public int evalRPN(String[] tokens) {
    Deque<Integer> s = new LinkedList<>();
    int num1 = 0, num2 = 0, val = 0;
    for (String str : tokens) {
      switch (str) {
        case "+":
          num1 = s.pop();
          num2 = s.pop();
          val = num2 + num1;
          s.push(val);
          break;
        case "-":
          num1 = s.pop();
          num2 = s.pop();
          val = num2 - num1;
          s.push(val);
          break;
        case "*":
          num1 = s.pop();
          num2 = s.pop();
          val = num2 * num1;
          s.push(val);
          break;
        case "/":
          num1 = s.pop();
          num2 = s.pop();
          val = num2 / num1;
          s.push(val);
          break;
        default:
          s.push(Integer.parseInt(str));
          break;
      }
    }
    if (s.isEmpty())
      return val;
    else if (s.size() == 1)
      return s.pop();
    else
      throw new IllegalArgumentException();
  }
}