package com.janhen.algorithm.sort.mergesort;

public class MergeSort {

    private static final int INSERTION_SORT_THRESHOLD = 47;

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int lo, int hi) {
        if (hi - lo <= INSERTION_SORT_THRESHOLD) {
            insertSort(arr, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, lo, mid, hi);
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] aux = new int[hi - lo + 1];
        int i = lo, j = mid + 1;
        // assign aux to sorted array
        for (int k = 0; k < aux.length; k++) {
            if (i > mid)
                aux[k] = arr[j++];
            else if (j > hi)
                aux[k] = arr[i++];
            else if (arr[i] < arr[j])
                aux[k] = arr[i++];
            else
                aux[k] = arr[j++];
        }
        // reassign original array
        for (int k = 0; k < aux.length; k++) {
            arr[k + lo] = aux[k];
        }
    }


    private static void insertSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int val = arr[i];
            int j = i;
            for (; j > lo && val < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];  // shift right
            }
            arr[j] = val;
        }
    }
}