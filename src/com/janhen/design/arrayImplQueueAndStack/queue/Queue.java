package com.janhen.design.arrayImplQueueAndStack.queue;

import java.util.NoSuchElementException;

public class Queue<E>  {

    private E[] data;
    private int frontIdx, tailIdx;
    private int N;

    public Queue(int capacity) {
        data = (E[]) new Object[capacity];
        frontIdx = 0;
        tailIdx = 0;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(E e) {
        if (N == data.length)
            throw new IllegalArgumentException("LinkedQueue is full.");
        data[tailIdx] = e;
        tailIdx = (tailIdx + 1) % data.length;
        N ++;
    }

    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedQueue is empty.");
        E oldFront = data[frontIdx];
        data[frontIdx] = null;
        frontIdx = (frontIdx + 1) % data.length;
        N --;
        return oldFront;
    }

    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedQueue is empty.");
        return data[frontIdx];
    }
}
