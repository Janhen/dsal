package com.janhen.structures.setAndmap.set;

public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);

    int size();
    boolean isEmpty();

}
