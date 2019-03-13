package com.janhen.design.arrayAsQueueAndStack;

public class Stack<E> implements IStack<E> {

    private E[] data;
    private int N;

    public Stack(int capacity) {
        data = (E[]) new Object[capacity];
        N = 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void push(E e) {
        if (N == data.length)
            throw new IllegalArgumentException("Stack is empty.");

        data[N] = e;
        N ++;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        E res = data[N - 1];

        data[N -1] = null;
        N --;
        return res;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Stack is empty.");

        return data[N - 1];
    }
}
