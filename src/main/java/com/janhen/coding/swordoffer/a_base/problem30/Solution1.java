package main.java.janhen.swordoffer.a_base.problem30;

import java.util.Stack;

public class Solution1 {

    Stack<Integer> min  = new Stack<>();
    Stack<Integer> data = new Stack<>();
    public void push(int node) {
        if (min.isEmpty() || min.peek() > node) min.push(node);
        else min.push(min.peek());
        data.push(node);
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