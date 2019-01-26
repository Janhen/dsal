package com.janhen.structures.queue.twoStackImpl;

import java.util.Stack;

public class Queue<E> {

    private Stack<E> s1;
    private Stack<E> s2;

    public Queue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(E e) {
        s1.push(e);
    }

    public E dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }

        if (s2.isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return s2.pop();
    }

    public E peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }

        if (s2.isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return s2.peek();
    }

}
