package com.janhen.coding.swordoffer.a_base.problem9;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Solution {

    private Stack<Integer> in  = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        in2out();
        return out.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        in2out();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void in2out() {
        // modify necessarily
        if (out.isEmpty()) {
            while (!in.isEmpty())
                out.push(in.pop());
        }
    }
}
