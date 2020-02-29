package com.janhen.swordoffer.stack_queue.problem31;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA,int[] popA) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        int N = pushA.length;
        while (i < N) {
            s.push(pushA[i]);
            while (j < N && !s.isEmpty() && s.peek() == popA[j]){
                s.pop();
                j ++;
            }
            i ++;
        }
        return s.isEmpty();
    }
}