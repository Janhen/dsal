package com.janhen.structures.heap_priorityQueue;

/**
 * 最大堆
 *
 * @see java.util.PriorityQueue
 */
public class MaxHeap<E extends Comparable<E>> {

  private static final int DEFAULT_CAPACITY = 11;

  private E[] data;
  private int N;

  public MaxHeap(int capacity) {
    data = (E[]) new Object[capacity];
    N = 0;
  }

  public MaxHeap() {
    this(DEFAULT_CAPACITY);
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(E e) {
    data[N] = e;
    swim(N); // maintain heap structure
    N++;
  }

  public E extractMax() {
    E oldMax = data[0];
    swap(0, N - 1);
    data[N - 1] = null; // mark-sweep
    N--;
    sink(0); // adjust relay on size
    return oldMax;
  }

  public E getMax() {
    if (isEmpty())
      throw new IllegalArgumentException();
    return data[0];
  }

  private void swim(int k) {
    while (k > 0 && less((k - 1) / 2, k)) { // parent<cur
      swap(k, (k - 1) / 2);
      k = (k - 1) / 2;
    }
  }

  private void sink(int k) {
    while (2 * k + 1 < N) {
      int j = 2 * k + 1;
      if (j + 1 < N && less(j, j + 1)) // left < right
        j = j + 1;
      if (!less(k, j)) // parent>=child
        break;
      swap(j, k);
      k = j;
    }
  }

  private boolean less(int i, int j) {
    return data[i].compareTo(data[j]) < 0;
  }

  private void swap(int i, int j) {
    E t = data[i];
    data[i] = data[j];
    data[j] = t;
  }
}
