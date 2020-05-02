package com.janhen.structures.set_map.set;

import com.janhen.structures.linkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {

  private LinkedList<E> list;

  public LinkedListSet() {
    list = new LinkedList<>();
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public void add(E e) {
    if (!list.contains(e))
      list.addFirst(e);
  }

  @Override
  public boolean contains(E e) {
    return list.contains(e);
  }

  @Override
  public void remove(E e) {
    list.removeElement(e);
  }
}
