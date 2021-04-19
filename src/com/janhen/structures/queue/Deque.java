package com.janhen.structures.queue;

public interface Deque<E> {

    void offerFirst(E val);

    void offerLast(E val);

    E pollFirst();

    E pollLast();

    boolean isEmpty();

    int size();

    E peekFirst();

    E peekLast();
}
