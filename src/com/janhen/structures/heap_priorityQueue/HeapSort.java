package com.janhen.structures.heap_priorityQueue;

/*
 * complete binary tree property : the last non leaf node is (n/2)th
 *  注意，此时我们的堆是从0开始索引的
 *  从(最后一个元素的索引-1)/2开始
 *  最后一个元素的索引 = n-1
 */

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int N = arr.length;
        for (int i = (N - 2)  / 2; i >= 0; i --)      // build heap
            sink(arr, i, N);
        while (N > 0) {                   // delete max ⇔ put into last position
            swap(arr, 0, -- N);
            sink(arr, 0, N);
        }
    }

    // PriorityQueue.siftDownComparable(k,e)
    private static void sink(int[] arr, int k, int N) {
        int val = arr[k];
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