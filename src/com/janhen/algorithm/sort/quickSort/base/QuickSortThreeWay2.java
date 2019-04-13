package com.janhen.algorithm.sort.quickSort.base;

public class QuickSortThreeWay2 {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;

        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        // partition queue
        int[] p = partition(arr, lo, hi);
        quickSort(arr, lo, p[0] - 1);
        quickSort(arr, p[1] + 1, hi);
    }

    private static int[] partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int lt = lo, gt = hi;
        int i = lo + 1;
        while (i <= gt) {
            if (arr[i] == pivot)
                i ++;
            else if (arr[i] < pivot)
                swap(arr, i ++, lt ++);
            else // arr[i] > pivot
                swap(arr, i, gt --);
        }
        return new int[] {lt, gt};
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}