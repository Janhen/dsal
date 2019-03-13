package com.janhen.design.arrayAsQueueAndStack;

public class Queue<E> implements IQueue<E> {

    private E[] data;
    private int N;

    public Queue(int capacity) {
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
    public void enqueue(E e) {
        if (N == data.length)
            throw new IllegalArgumentException("Queue is full");

        data[N] = e;
        N ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        E res = data[0];
        // shift left
        for (int i = 1; i < N; i ++)
            data[i - 1] = data[i];

        data[N - 1] = null;
        N --;
        return res;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");

        return data[0];
    }
}
