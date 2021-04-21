package com.janhen.structures.design.stackwithmin;

import java.util.NoSuchElementException;
import java.util.Stack;

class MinStack {
    private final Stack<Integer> data = new Stack<>();
    private final Stack<Integer> min = new Stack<>();

    public void push(int x) {
        if (data.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
        data.push(x);
    }

    public void pop() {
        if (data.isEmpty())
            throw new NoSuchElementException();
        if (data.peek().equals(min.peek()))
            min.pop();
        data.pop();
    }

    public int top() {
        if (data.isEmpty())
            throw new NoSuchElementException();
        return data.peek();
    }

    public int getMin() {
        if (data.isEmpty())
            throw new NoSuchElementException();
        return min.peek();
    }
}
