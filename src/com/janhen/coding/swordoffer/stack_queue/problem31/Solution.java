package com.janhen.coding.swordoffer.stack_queue.problem31;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA,int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        int N = pushA.length;
        while (i < N) {
            stack.push(pushA[i]);
            while (j < N && !stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j ++;
            }
            i ++;
        }
        return stack.isEmpty();
    }
}