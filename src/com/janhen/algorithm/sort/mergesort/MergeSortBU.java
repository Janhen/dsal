package com.janhen.algorithm.sort.mergesort;

public class MergeSortBU {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int N = arr.length;
        for (int sz = 1; sz < N; sz += sz)               // sz: subarray size
            for (int i = 0; i + sz < N; i += sz + sz)     // i subarray index
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] aux = new int[hi - lo + 1];
        int i = lo, j = mid + 1;
        for (int k = 0; k < aux.length; k ++) {
            if (i > mid)
                aux[k] = arr[j ++];
            else if (j > hi)
                aux[k] = arr[i ++];
            else if (arr[i] < arr[j])
                aux[k] = arr[i ++];
            else
                aux[k] = arr[j ++];
        }
        for (i = 0; i < aux.length; i ++)
            arr[i + lo] = aux[i];
    }
}
