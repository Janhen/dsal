package com.janhen.algorithm.sort.quickSort;

// insertion and get median as pivot
public class QuickSortMedian {

    private final static int INSERT_SORT_THRESHOLD = 7;

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo + INSERT_SORT_THRESHOLD) {
            insertionSort(arr, lo, hi);
            return;
        }
        int median = medianOf3(arr, lo, hi);
        int i = partition(arr, lo, hi, median);
        quickSort(arr, lo, i - 1);
        quickSort(arr, i + 1, hi);
    }

    // [lo]<=pivot is order,[hi]>=pivot is order, [hi-1]==pivot is order
    private static int partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo, j = hi - 1;
        while (true) {
            while (arr[++ i] < pivot);    // [hi]>=pivot  as sentinel
            while (arr[-- j] > pivot);    // [lo]<=pivot
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, i, hi - 1);     // put pivot to correct position
        return i;
    }

    private static int medianOf3(int[] arr, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[lo] > arr[mid]) swap(arr, lo, mid);
        if (arr[lo] > arr[hi]) swap(arr, lo, hi);
        if (arr[mid] > arr[hi]) swap(arr, mid, hi);
        swap(arr, mid, hi - 1);
        return arr[hi - 1];
    }


    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i ++) {
            int e = arr[i], j = i;
            for (; j > lo && e < arr[j - 1]; j --)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }
}