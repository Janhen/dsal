package com.janhen.structures.heapAndpriorityQueue;

public interface IHeap<E extends Comparable<E>> {

    int size();
    boolean isEmpty();

    void insert(E val);
    E delMax();
    E getMax();

}
