package com.janhen.design.arrayimplqueue;

import java.util.NoSuchElementException;

/**
 * 使用数组实现队列
 * - 不自动扩缩容<br>
 * - 记录队列头部和尾部的索引实现<br>
 * - 每次出对，更改头索引+1
 * {@link java.util.ArrayDeque}
 */
public class Queue<E> {
  private E[] data;
  private int N;
  private int frontIdx;
  private int tailIdx;

  public Queue(int capacity) {
    data = (E[]) new Object[capacity];
    frontIdx = 0;
    tailIdx = 0;
    N = 0;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void enqueue(E e) {
    if (N == data.length)
      throw new IllegalArgumentException("LinkedQueue is full.");
    data[tailIdx] = e;
    tailIdx = (tailIdx + 1) % data.length;
    N++;
  }

  public E dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("LinkedQueue is empty.");
    E oldFront = data[frontIdx];
    data[frontIdx] = null;
    frontIdx = (frontIdx + 1) % data.length;
    N--;
    return oldFront;
  }

  public E peek() {
    if (isEmpty())
      throw new NoSuchElementException("LinkedQueue is empty.");
    return data[frontIdx];
  }
}
