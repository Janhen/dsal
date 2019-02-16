package com.janhen.structures.heapAndpriorityQueue.base;

public class HeapSort<E extends Comparable<E>> {

    public void sort(E[] arr) {
        if (arr == null || arr.length < 2)
            return ;

        // [0] store element
        // [0,1,2,3,4,5,6]
        //  k
        // parent: (k-1)/2
        // left:   2*k+1
        // right:  2*k+2
        // [N-1] is last element
        int N = arr.length;
        // step1: construct max heap
        for (int i = N/2; i >= 0; i --)
            sink(arr, i, N);
        // step2: delete element from max heap
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
