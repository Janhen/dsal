package com.janhen.design.arrayAsQueueAndStack;

public interface IQueue<E> {

    int size();
    boolean isEmpty();

    void enqueue(E e);
    E dequeue();
    E peek();
}
