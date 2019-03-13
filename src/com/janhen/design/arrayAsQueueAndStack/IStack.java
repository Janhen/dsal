package com.janhen.design.arrayAsQueueAndStack;

public interface IStack<E> {

    boolean isEmpty();
    int size();

    void push(E e);
    E pop();
    E peek();

}
