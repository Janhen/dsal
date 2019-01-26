package com.janhen.structures.heapAndpriorityQueue.base;

import com.janhen.structures.heapAndpriorityQueue.IHeap;

import java.util.NoSuchElementException;

public class Heap<E extends Comparable<E>> implements IHeap<E> {

    private E[] data;  // ★ [1] begin storage element
    private int N;
    private int capacity;

    public Heap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];  // ★
        this.capacity = capacity;
        N = 0;
    }

    // time:O(n)
    public Heap(E[] arr) {
        data = (E[]) new Comparable[arr.length + 1];
        capacity = arr.length;
        for (int i = 0; i < arr.length; i ++)
            data[i + 1] = arr[i];
        N = arr.length;
        for (int i = N / 2; i >= 1; i --)
            sink(i);
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void insert(E val) {
        assert N + 1 <= capacity;
        N ++;
        data[N] = val;
        swim(N);
    }

    @Override
    public E delMax() {
        if (isEmpty())
            throw new IllegalArgumentException();

        E oldMax = data[1];
        swap(1, N);
        N --;
        data[N+1] = null;    // ★
        sink(1);
        return oldMax;
    }

    @Override
    public E getMax() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data[1];
    }

    private void sink(int k) {
        while (k*2 <= N) {
            int j = k*2;
            if (j + 1 <= N && data[j].compareTo(data[j + 1]) < 0)
                j = j + 1;
            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(k, j);
        }
    }

    private void swim(int k) {
        while (k > 1 && data[k].compareTo(data[k/2]) > 0) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void swap(int i, int j) {
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
