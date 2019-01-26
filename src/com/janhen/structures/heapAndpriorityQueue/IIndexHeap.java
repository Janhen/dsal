package com.janhen.structures.heapAndpriorityQueue;

public interface IIndexHeap<E extends Comparable<E>> {

    void insert(int i, E newEle);

    E getElement(int i);

    E extractMax();
    int extractMaxIndex();

    E getMax();
    int getMaxIndex();

    void change(int i, E newEle);

}
