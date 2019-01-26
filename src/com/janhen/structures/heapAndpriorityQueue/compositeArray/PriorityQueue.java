package com.janhen.structures.heapAndpriorityQueue.compositeArray;

import com.janhen.structures.queue.IQueue;


public class PriorityQueue<E extends Comparable<E>> implements IQueue<E> {

    private MaxHeap<E> heap;

    public PriorityQueue(int capacity) {
        heap = new MaxHeap<>(capacity);
    }

    public PriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E dequeue() {
        return heap.extractMax();
    }

    @Override
    public E peek() {
        return heap.findMax();
    }




















    private static final int DEFAULT_CAPACITY = 10;
}
