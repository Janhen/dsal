package com.janhen.structures.heap_priorityQueue;

public interface IHeap<E extends Comparable> {

    int size();
    boolean isEmpty();

    void insert(E val);
    E extractMax();
    E getMax();
}
