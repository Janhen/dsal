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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        rebalance();
        return out.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        rebalance();
        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    // in to out make out.peek as queue first element
    private void rebalance() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
