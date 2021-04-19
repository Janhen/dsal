package com.janhen.algorithm.sort.heapsort.base;

public interface IHeap<E> {
    void offer(E e);

    E poll();

    E peek();

    boolean isEmpty();

    int size();
}
