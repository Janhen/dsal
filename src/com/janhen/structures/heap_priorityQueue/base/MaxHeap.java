package com.janhen.structures.heap_priorityQueue.base;

import com.janhen.structures.heap_priorityQueue.IHeap;

import java.util.NoSuchElementException;

public class MaxHeap<E extends Comparable> implements IHeap<E> {

    // [ ,1,2,3,4,5,6]
    //    k
    // parent: k/2
    // left child: 2*k
    // right child: 2*k+1
    protected E[] data;  // [1] begin storage element
    protected int N;
    protected int capacity;

    public MaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];  // store
        this.capacity = capacity;
        N = 0;
    }

    // time:O(n)
    public MaxHeap(E[] arr) {
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
    public E extractMax() {
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

    // compare(cur, max{left,right})
    //    - P1: <   swap(cur,max{left,right})
    //    - P2: >=  over
    private void sink(int k) {
        while (k*2 <= N) {
            int j = k*2;
            if (j + 1 <= N && data[j].compareTo(data[j + 1]) < 0)
                j = j + 1;
            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k/2 > 0 && data[k].compareTo(data[k/2]) > 0) {
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
