package com.janhen.structures.heapAndpriorityQueue.base;

public class HeapSort<E extends Comparable<E>> {

    public void sort(E[] arr) {
        if (arr == null || arr.length < 2)
            return ;

        int N = arr.length;
        for (int i = N/2; i >= 0; i --)
            sink(arr, i, N);
        while (N > 0) {
            swap(arr, 0, -- N);
            sink(arr, 0, N);
        }
    }

    private void sink(E[] arr, int k, int N) {
        while (k*2+1 < N) {
            int j = k*2+1;
            if (j + 1 < N && arr[j].compareTo(arr[j + 1]) < 0)
                j = j + 1;
            if (arr[k].compareTo(arr[j]) >= 0)
                break;
            swap(arr, k, j);
            k = j;
        }
    }

    private void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
