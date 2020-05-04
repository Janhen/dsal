package com.janhen.algorithm.sort.quicksort;

/**
 * 基础快速排序
 *
 * @author Janhen
 */
public class QuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 7;

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < INSERTION_SORT_THRESHOLD) {               // small size ⇒ insertSort
            insertSort(arr, lo, hi);
            return;
        }
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        swap(arr, lo, lo + (int) (Math.random() * (hi-lo+1)));       // like shuffle
        int pivot = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++ i] < pivot && i != hi);
            while (arr[-- j] > pivot && j != lo);
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, j, lo);
        return j;
    }
    

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void insertSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i ++) {
            int e = arr[i], j = i;
            for (; j > lo && e < arr[j-1]; j --)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }
}
