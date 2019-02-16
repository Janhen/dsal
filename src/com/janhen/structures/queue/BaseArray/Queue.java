package com.janhen.structures.queue.BaseArray;

import com.janhen.structures.array.dynamic.Array;
import com.janhen.structures.queue.IQueue;

public class Queue<E> implements IQueue<E> {

    private Array<E> arr;

    public Queue(int capacity) {
        arr = new Array<>(capacity);
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }


    public int size() {
        return arr.size();
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    // rpush+lpop
    public void enqueue(E item) {
        arr.addLast(item);
    }

    public E dequeue() {
        return arr.removeFirst();
    }

    public E peek() {
        return arr.getFirst();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue : size = ").append(size()).append(" : ");
        sb.append("front [");
        for (int i = 0;i < arr.size(); i++) {
            sb.append(i == arr.size() - 1 ? arr.get(i) : arr.get(i) + ", ");
        }
        sb.append("] tail");
        return sb.toString();
    }

    private static final int DEFAULT_CAPACITY = 10;
}
