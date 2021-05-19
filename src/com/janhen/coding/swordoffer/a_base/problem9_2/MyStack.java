package com.janhen.coding.swordoffer.a_base.problem9_2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

// pop(), top() 时保持
public class MyStack {
    private Queue<Integer> data = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        rebalance();
        Integer peek = data.poll();
        swap();
        return peek;
    }

    public int top() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        rebalance();
        Integer peek = data.poll();
        // putback
        help.offer(peek);
        swap();
        return peek;
    }

    public boolean empty() {
        return data.isEmpty();
    }

    // make data stack element as stack peek element
    private void rebalance() {
        while (data.size() > 1) {
            help.offer(data.poll());
        }
    }

    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }
}
