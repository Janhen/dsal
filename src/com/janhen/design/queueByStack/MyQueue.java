package com.janhen.design.queueByStack;

import java.util.NoSuchElementException;
import java.util.Stack;

class MyQueue {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (empty())
            throw new NoSuchElementException();
        in2out();
        return out.pop();
    }

    public int peek() {
        if (empty())
            throw new NoSuchElementException();
        in2out();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    // modify necessarily
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }
    }
}
