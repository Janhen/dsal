package com.janhen.algorithm.sort.quickSort;

public class QuickSortThreeWay {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int[] p = partition(arr, lo, hi);
        quickSort(arr, lo, p[0] - 1);
        quickSort(arr, p[1] + 1, hi);
    }

    private static int[] partition(int[] arr, int lo, int hi) {
        swap(arr, lo, lo + (int) (Math.random()*(hi-lo+1)));
        int pivot = arr[lo];            // [lo] as pivot
        int lt = lo - 1, gt = hi + 1;
        int i = lo;
        while (i < gt) {
            if (arr[i] == pivot)
                i ++;
            else if (arr[i] < pivot)
                swap(arr, i ++, ++ lt);
            else // arr[i] > pivot
                swap(arr, i, -- gt);
        }
        return new int[] {lt + 1, gt - 1};
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}