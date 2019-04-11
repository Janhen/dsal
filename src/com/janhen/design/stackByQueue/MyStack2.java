package com.janhen.design.stackByQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack2 {

    Queue<Integer> data = new LinkedList<>();
    Queue<Integer> help = new LinkedList<>();

    public void push(int x) {
        data.offer(x);
    }

    public int pop() {
        if (empty())
            throw new NoSuchElementException();
        while (data.size() > 1)
            help.offer(data.poll());
        int oldTop = data.poll();
        swap();
        return oldTop;
    }

    public int top() {
        if (empty())
            throw new NoSuchElementException();
        while (data.size() > 1)
            help.offer(data.poll());
        int top = data.poll();
        help.offer(top);
        swap();
        return top;
    }

    public boolean empty() {
        return data.isEmpty();
    }

    private void swap() {
        Queue<Integer> t = data;
        data = help;
        help = t;
    }
}
