package com.janhen.structures.queue;

public interface IQueue<E> {
  // queue
  void enqueue(E item);
  E dequeue();
  E peek();
  //
  int size();
  boolean isEmpty();
}
