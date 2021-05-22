package com.janhen.coding.swordoffer.a_base.problem9;

import java.util.NoSuchElementException;
import java.util.Stack;

// peek, pop 时，将 in 中的所有元素放入到 out, 保证 out.peek() / out.pop() 为队首元素
public class Solution {
    // push element
    private Stack<Integer> in  = new Stack<>();
    // pop/peek element
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
        // out not empty, than continue to pop/peek
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
