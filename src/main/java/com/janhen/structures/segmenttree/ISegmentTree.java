package com.janhen.structures.segmenttree;

public interface ISegmentTree<E> {
  E query(int queryL, int queryR);
  void set(int index, E e);
}
