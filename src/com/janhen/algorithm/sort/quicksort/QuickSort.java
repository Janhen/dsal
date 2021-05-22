package com.janhen.algorithm.sort.quicksort;

/**
 * 基础快速排序
 */
public class QuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 7;

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < INSERTION_SORT_THRESHOLD) {               // small size ⇒ insertSort
            insertSort(arr, lo, hi);
            return;
        }
        int j = partition(arr, lo, hi);
        // j in real position, then sort [lo, j-1] and [j+1, hi]
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        swap(arr, lo, lo + (int) (Math.random() * (hi - lo + 1)));       // like shuffle
        int pivot = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            // find pivot left half not < pivot element index, hi as guard
            while (arr[++i] < pivot && i != hi) ;
            // find pivot right half not > pivot element index, lo as guard
            while (arr[--j] > pivot && j != lo) ;
            // now [lo+1,hi] meet pivot left and right condition
            if (i >= j) break;
            // not meet condition, adjust element position
            swap(arr, i, j);
        }
        // put pivot in correct position
        swap(arr, j, lo);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void insertSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int e = arr[i], j = i;
            for (; j > lo && e < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
