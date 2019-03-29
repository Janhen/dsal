package com.janhen.algorithm.sort.heapSort.base;

public interface IHeap<E> {
    void offer(E e);
    E poll();
    E peek();

    boolean isEmpty();
    int size();
}
