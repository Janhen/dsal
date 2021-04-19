package com.janhen.design.arrayimplstack;

import java.util.NoSuchElementException;

public class Stack<E> {
    private final E[] data;
    private int N;

    public Stack(int capacity) {
        data = (E[]) new Object[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(E e) {
        if (N == data.length)
            throw new NoSuchElementException("Stack is empty.");
        data[N] = e;
        N++;
    }

    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty.");
        E oldTop = data[N - 1];
        data[N - 1] = null;
        N--;
        return oldTop;
    }

    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty.");
        return data[N - 1];
    }
}
