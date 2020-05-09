package com.janhen.coding.leetcode.stack_queue_heap.sm_nested_ugly_diff_polish_decode_next.solution150;

// 150. Evaluate Reverse Polish Notation
//https://leetcode.com/problems/evaluate-reverse-polish-notation/

/*

Medium

425

311

计算逆波兰表达式

Share
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */

import java.util.Deque;
import java.util.LinkedList;

class Solution {

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