package com.janhen.structures.queue.baseLoopArray;

import com.janhen.structures.queue.IQueue;

import java.util.NoSuchElementException;

/**
 * 循环数组实现队列
 * @see java.util.concurrent.ArrayBlockingQueue
 */
public class Queue2<E> implements IQueue<E> {
    private E[] data;
    private int N;
    private int first, last;

    public Queue2(int initSize) {
        if (initSize <= 0)
            throw new IllegalArgumentException();
        data = (E[]) new Object[initSize]; 
        N = 0;
        first = 0;
        last = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(E item) {
        if (N == data.length)
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        data[last] = item;
        last = last == data.length - 1 ? 0 : last + 1;
        N ++;
    }

    public E dequeue() {
        if (isEmpty())
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        E oldFront = data[first];
        data[first] = null;
        first = first == data.length - 1 ? 0 : first + 1;
        N --;
        return oldFront;
    }

    // rpush + lpop
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data[first];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front [");
        for (int i = 0; i < size(); i ++) {
            int curIndex = (i + first) % data.length;
            sb.append(i != size()-1 ? data[curIndex] + ", " : data[curIndex]);
        }
        sb.append("] tail");
        return sb.toString();
    }
}