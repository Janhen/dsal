package com.janhen.coding.swordoffer.a_base.problem30;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Solution2_ {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public void push(int node) {
        if (min.isEmpty()) {
            min.push(node);
        } else if (node <= min.peek()) {
            min.push(node);
        }
        data.push(node);
    }

    public void pop() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }
        int oldTop = data.pop();
        if (oldTop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }
        return data.peek();
    }

    public int min() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }
        return min.peek();
    }
}
