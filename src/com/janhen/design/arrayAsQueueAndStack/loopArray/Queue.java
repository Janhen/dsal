package com.janhen.design.arrayAsQueueAndStack.loopArray;

import com.janhen.design.arrayAsQueueAndStack.IQueue;

public class Queue<E> implements IQueue<E> {

    private E[] data;
    private int front, tail;
    private int N;

    public Queue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
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
            throw new IllegalArgumentException("Queue is full.");

        data[tail] = e;
        tail = (tail + 1) % data.length;
        N ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("ICatDogQueue is empty.");

        E oldFrontVal = data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        N --;
        return oldFrontVal;
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;

        return data[front];
    }
}
