package com.janhen.structures.design.arrayimplqueue;

import com.janhen.structures.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * shift element 实现
 */
public class Queue2<E> implements IQueue<E> {
    private final E[] data;
    private int N;

    public Queue2(int capacity) {
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
            throw new NoSuchElementException("LinkedQueue is full");
        data[N] = e;
        N++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedQueue is empty.");
        E oldFront = data[0];
        for (int i = 1; i < N; i++) // shift left
            data[i - 1] = data[i];
        data[N - 1] = null;
        N--;
        return oldFront;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue2 is empty.");
        return data[0];
    }
}
