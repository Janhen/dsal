package com.janhen.structures.heapAndpriorityQueue.compositeArray;

import com.janhen.structures.array.dynamic.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    // [0] store element
    // parent: (k-1)/2
    // left:   k*2+1;
    // right:  k*2+2
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>(DEFAULT_CAPACITY);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException();
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // swim     sign up
    public void add(E e) {
        data.add(e);
        swim(size() - 1);
    }

    // only get max
    public E findMax() {
        if (isEmpty())
            throw new IllegalArgumentException();

        return data.get(0);
    }

    // pop max element
    public E extractMax() {
        E ret = findMax();

        swap(0, size() - 1);
        data.removeLast();
        sink(0);
        return ret;
    }

    // shift down
    private void sink(int k) {

        // data.set(0, data.getLast());
        // data.removeLast();
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (j + 1 < size() && data.get(j).compareTo(data.get(rightChild(k))) < 0)
                j = rightChild(k);

            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;

            swap(j, k);
            k = j;
        }
    }

    // only compare parent
    private void swim(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    private void swap(int i, int j) {
        if (i < 0 || i >= size() || j < 0 || j >= size())
            throw new IllegalArgumentException();

        E t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }


    private static final int DEFAULT_CAPACITY = 10;
}
