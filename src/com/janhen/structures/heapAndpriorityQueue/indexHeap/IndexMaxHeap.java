package com.janhen.structures.heapAndpriorityQueue.indexHeap;

import com.janhen.structures.heapAndpriorityQueue.IIndexHeap;

public class IndexMaxHeap<E extends Comparable<E>> implements IIndexHeap<E> {

    private E[] data;
    private int[] indexs;
    private int N;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = (E[]) new Comparable[capacity + 1];
        indexs = new int[capacity + 1];
        N = 0;
        this.capacity = capacity;
    }

    public void insert (int i, E item) {

        assert (N + 1 <= capacity);
        assert (i + 1 >= 1 && i + 1 <= capacity);

        i += 1;  // ★ from one to storage
        data[i] = item;
        indexs[N + 1] = i;
        N ++;
        swim(N);
    }

    public E getElement(int i) {
        return data[i + 1];
    }

    public E extractMax() {
        assert (N > 0);

        E oldMax = data[indexs[1]];
        swap(indexs, 1, N);
        N --;
        sink(1);
        return oldMax;
    }

    // ★★
    public void change(int i, E newItem) {
        i += 1;
        data[i] = newItem;

        // indexs[j] = i, j 为  data[i] 在 heap 中的位置

        // O(N) + O(logN)
        for (int j = 1; j <= N; j ++) {
            if (indexs[j] == i) {
                swim(j);
                sink(j);
                return;
            }
        }
    }

    public int extractMaxIndex() {
        assert (N > 0);

        int ret = indexs[1] - 1;   // ★ base-1
        swap(indexs, 1, N);
        N --;
        sink(1);

        return ret;
    }

    @Override
    public E getMax() {
        return data[indexs[1]];
    }

    @Override
    public int getMaxIndex() {
        return indexs[1] - 1;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && less(j, j + 1))
                j ++;

            if (!less(indexs[k], indexs[j]))
                break;

            swap(indexs, j, k);
            k = j;
        }
    }

    private void swim(int k) {
        // compare
        while (k > 1 && less(indexs[k / 2], indexs[k])) {
            // swap index
            swap(indexs, k / 2, k);
            k = k / 2;
        }
    }

    private void swap(int[] indexs, int i, int j) {
        int t = indexs[i];
        indexs[i] = indexs[j];
        indexs[j] = t;
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

}
