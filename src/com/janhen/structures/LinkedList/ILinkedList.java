package com.janhen.structures.LinkedList;

public interface ILinkedList<E> {

    int size();
    boolean isEmpty();

    void add(int index, E val);
    void addFirst(E val);
    void addLast(E val);

    boolean contains(E val);

    E get(int index);
    E getLast();
    E getFirst();

    void set(int index, E val);

    E remove(int index);
    E removeFirst();
    E removeLast();
    void removeElement(E val);

}
