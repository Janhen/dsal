package com.janhen.algorithm.sort.heapsort.base;

public class HeapSortBase {

    // time : O(nlogn)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i ++)
            heapify(arr, i);                            // heapInsert
        int N = arr.length;
        while (N > 0) {                              // heapify: delete and adjust heap structure
            swap(arr, -- N, 0);
            sink(arr, N, 0);
        }
    }

    private static void heapify(int[] arr, int k) {
        while (arr[k] > arr[(k - 1) / 2]) {
            swap(arr, k, (k - 1) / 2);
            k = (k - 1) / 2;
        }
    }

    private static void sink(int[] arr, int N, int k) {
        while (2 * k + 1 < N) {
            int j = 2 * k + 1;
            if (j + 1 < N && arr[j] < arr[j + 1])
                j ++;
            if (arr[k] >= arr[j])
                break;
            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}