package com.janhen.coding.leetcode.top100.recursion_dp_backtracking.solution32;

import java.util.Stack;

class Solution {
    // 先删除掉可以成对的括号
    // 之后通过无法成对的括号进行范围控制
    public int longestValidParentheses(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == '(') stack.push(i);    // (
            else {                      // )
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                if (s.charAt(stack.peek()) == '(')   // 当前为 ), 栈顶为 ( 可以匹配, 弹出, 使得栈保存无法成对的下标
                    stack.pop();
                else
                    stack.push(i);      // ) 无法成对, continue to put
            }
        }
        if (stack.isEmpty())            // all valid
            return n;

        int nextIndex = n, curIndex = 0;      // next not match index, cur not match index;
        while (!stack.empty()) {                        // stack store not matched parentheses
            curIndex = stack.pop();
            longest = Math.max(longest, nextIndex-curIndex-1);
            nextIndex = curIndex;
        }
        longest = Math.max(longest, nextIndex);
        return longest;
    }
}
/*
https://leetcode.com/problems/longest-valid-parentheses/discuss/14126/My-O(n)-solution-using-a-stack
*/