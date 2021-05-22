package com.janhen.coding.swordoffer.a_base.problem30;

import java.util.Stack;

public class Solution {
    private Stack<Integer> data = new Stack<>();
    // keep current element min val
    private Stack<Integer> min = new Stack<>();

    public void push(int val) {
        // synchronization push
        if (min.isEmpty() || min.peek() > val) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
        data.push(val);
    }

    public void pop() {
        min.pop();
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}