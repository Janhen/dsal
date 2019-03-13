package com.janhen.design.stackByTwoQueue;
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
        E oldTop = data.poll();
        swap();
        return oldTop;
    }

    public E peek() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        while (data.size() > 1)
            help.add(data.poll());
        E oldTop = data.poll();
        help.add(oldTop);
        swap();          // reset
        return oldTop;
    }

    private void swap() {
        Queue<E> t = data;
        data = help;
        help = t;
    }
}
