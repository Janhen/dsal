package com.janhen.structures.segmentTree;

public interface ISegmentTree<E> {

    // container to build

    E query(int queryL, int queryR);

    void set(int index, E e);

}
