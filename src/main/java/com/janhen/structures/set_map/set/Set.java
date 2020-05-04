package com.janhen.structures.set_map.set;

public interface Set<E> {
  void add(E e);
  boolean contains(E e);
  void remove(E e);
  int size();
  boolean isEmpty();
}
