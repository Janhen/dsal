package com.janhen.structures.BST;

public interface IBST<E extends Comparable<E>> {
    int size();
    boolean isEmpty();

    void add(E e);
    boolean contains(E e);
    void remove(E e);

    // order

    E maximum();
    E minimum();
    E removeMin();
    E removeMax();

    //    List<E> range(int fromIndex, int toIndex);
    //    E successor(E e);
    //    E predecessor(E e);
    //    int rank(E e);
    //    E select(int index);
}
