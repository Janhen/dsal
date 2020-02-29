package com.janhen.swordoffer.stack_queue.problem31;

import java.util.Stack;

public class Solution2 {
    public boolean IsPopOrder(int[] pushA,int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int n = pushA.length;
        for (int j=0; j < popA.length; j ++) {
            while (stack.isEmpty() || stack.peek() != popA[j]) {    // try make top is pop
                if (i >= n)
                    break;
                stack.push(pushA[i++]);
            }
            if (stack.peek() != popA[j])      // try all push AND still not meet
                return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}