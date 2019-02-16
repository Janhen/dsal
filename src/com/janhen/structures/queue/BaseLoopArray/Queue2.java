package com.janhen.structures.queue.BaseLoopArray;

import com.janhen.structures.queue.IQueue;

import java.util.NoSuchElementException;

public class Queue2<E> implements IQueue<E> {
    private E[] arr;
    private int N;
    private int first, last;     // point to add element

    public Queue2(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = (E[]) new Object[initSize];
        N = 0;
        first = 0;
        last = 0;
    }

    // rpush + lpop
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return arr[first];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(E item) {
        if (N == arr.length) throw new ArrayIndexOutOfBoundsException("The queue is full");

        arr[last] = item;
        last = last == arr.length - 1 ? 0 : last + 1;
        N ++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        int oldFrontIndex = first;
        first = first == arr.length - 1 ? 0 : first + 1;
        N --;
        return arr[oldFrontIndex];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front [");
        for (int i = 0; i < size(); i ++) {
            int curIndex = (i + first) % arr.length;
            sb.append(i != size()-1 ? arr[curIndex] + ", " : arr[curIndex]);
        }
        sb.append("] tail");
        return sb.toString();
    }
}