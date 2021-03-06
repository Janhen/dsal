package com.janhen.structures.design.queueimplstack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack2 {
    private final Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);
        int cnt = queue.size();
        // reverse queue element, offer(poll())
        while (cnt-- > 1) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        if (empty())
            throw new NoSuchElementException();
        return queue.poll();
    }

    public int top() {
        if (empty())
            throw new NoSuchElementException();
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
