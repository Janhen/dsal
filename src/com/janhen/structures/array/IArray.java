package com.janhen.structures.array;

public interface IArray<E> {
    void add(E v);
    void addFirst(E v);
    void addLast(E v);

    void add(int index, E v);

    int find(E v);          // select ? rank ?

    E get(int index);
    E getFirst();           // peekFirst
    E getLast();            // peekLast

    boolean contains(E v);

    E remove(int index);
    E removeFirst();        // pollFirst
    E removeLast();         // pollLast
    void removeElement(E v);

    void set(int index, E v);

    int size();
    boolean isEmpty();
}
