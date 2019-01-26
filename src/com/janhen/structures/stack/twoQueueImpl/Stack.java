package com.janhen.structures.stack.twoQueueImpl;
import java.util.LinkedList;
import java.util.Queue;

public class Stack<E> {

    private Queue<E> data;
    private Queue<E> help;

    public Stack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(E e) {
        data.add(e);
    }

    public E pop() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Stack is empty");

        while (data.size() > 1)
            help.add(data.poll());
        swap();
        return data.poll();
    }

    public E peek() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        while (data.size() > 1)
            help.add(data.poll());

        E res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    private void swap() {
        Queue<E> t = data;
        data = help;
        help = t;
    }
}
