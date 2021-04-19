package com.janhen.algorithm.sort.heapsort;

import com.janhen.algorithm.sort.heapsort.base.IHeap;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> implements IHeap<E> {

    private static final int DEFAULT_CAPACITY = 11;
    private final E[] data;
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

    public void offer(E e) {
        data[N] = e;
        N++;
        swim(N - 1);
    }

    public E poll() {
        E ret = data[0];
        swap(0, N - 1);
        data[N - 1] = null;   //
        N--;
        sink(0);
        return ret;
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException();
        return data[0];
    }

    private void swim(int k) {
        while (k > 0 && less((k - 1) / 2, k)) {       // parent>cur
            swap(k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j + 1 < N && less(j, j + 1))
                j = j + 1;
            if (!less(k, j))      // parent>=child
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
