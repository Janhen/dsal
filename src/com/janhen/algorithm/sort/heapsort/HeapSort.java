package com.janhen.algorithm.sort.heapsort;

/**
 * complete binary tree property : the last non leaf node is (n/2)th
 *
 * @see java.util.PriorityQueue
 * siftDownComparable(k,e)
 * heapify
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int N = arr.length;
        for (int i = (N - 2)  / 2; i >= 0; i --)
            sink(arr, i, N);
        while (N > 0) {
            swap(arr, 0, -- N);
            sink(arr, 0, N);
        }
    }

    private static void sink(int[] arr, int k, int N) {
        int val = arr[k];               // put val in correct position
        while (k * 2 + 1 < N) {
            int j = k * 2 + 1;
            if (j + 1 < N && arr[j] < arr[j + 1])
                j = j + 1;
            if (val >= arr[j])         // compare val to find correct position
                break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = val;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}