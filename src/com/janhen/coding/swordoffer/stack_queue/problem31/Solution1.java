package com.janhen.coding.swordoffer.stack_queue.problem31;

import java.util.Stack;

public class Solution1 {
    // 判断下一个要弹出的元素：
    // 如果刚好是栈顶元素，直接弹出。
    // 如果不在栈顶，则把压栈序列中还没有入栈的数字压入栈，直到待弹出的数字压入栈顶。
    // 如果所有数字都压入栈顶后依然没有后找到下一个弹出的数字，则不可能是弹出序列。
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int N = pushA.length;
        for  (int i = 0;i < N; i ++) {
            stack.push(pushA[i]);
            // try to pop
            while (j < N && !stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}