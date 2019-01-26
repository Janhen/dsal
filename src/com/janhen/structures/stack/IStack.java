package com.janhen.structures.stack;

public interface IStack<E> {
    void push(E item);
    E pop();
    E peek();

    int size();
    boolean isEmpty();
}
