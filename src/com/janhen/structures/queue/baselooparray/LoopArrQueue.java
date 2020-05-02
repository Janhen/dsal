package com.janhen.structures.queue.baselooparray;

import com.janhen.structures.queue.IQueue;

/**
 * 循环数组实现队列
 * 
 * @param <E>
 */
public class LoopArrQueue<E> implements IQueue<E> {

  private E[] data;
  private int front, tail; // tail->lastElement
  private int N;

  public LoopArrQueue(int capacity) {
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;
    N = 0;
  }

  public LoopArrQueue() {
    this(DEFAULT_CAPACITY);
  }

  @Override
  public int size() {
    return N;
  }

  @Override
  public boolean isEmpty() {
    return front == tail;
  }

  public int capacity() {
    return data.length - 1;
  }

  @Override
  public void enqueue(E item) {
    if ((tail + 1) % data.length == front) {// full condition: front and tail ...
      resize(capacity() * 2);
    }

    data[tail] = item;
    tail = (tail + 1) % data.length;
    N++;
  }

  @Override
  public E dequeue() {
    if (isEmpty())
      throw new IllegalArgumentException();

    E oldFront = data[front];
    data[front] = null;
    front = (front + 1) % data.length;
    N--;

    // 1/4 to downsizing
    if (N == capacity() / 4 && capacity() / 2 != 0)
      resize(capacity() / 2);
    return oldFront;
  }

  @Override
  public E peek() {
    if (isEmpty())
      throw new IllegalArgumentException();

    return data[front];
  }

  private void resize(int newCapacity) {
    // reserved one element
    E[] newData = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < size(); i++) {
      newData[i] = data[(i + front) % data.length]; // from front to tail AND need offset
    }
    data = newData;
    front = 0;
    tail = N; // reset front, tail;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("Queue2 : size = %d, capacity = %d \n", size(), capacity()));
    sb.append("front [");
    // traverse from index front to tail
    for (int i = 0; i < size(); i++) {
      int curIndex = (i + front) % data.length;
      sb.append(curIndex != tail - 1 ? data[curIndex] + ", " : data[curIndex]);
    }
    sb.append("] tail");
    return sb.toString();
  }

  private static final int DEFAULT_CAPACITY = 10;
}
