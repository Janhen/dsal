package com.janhen.algorithm.sort.quickSort.base;

public class QuickSortShuffle {

    // shuffle all array
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;

        shuffle(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j - 1);
        quickSort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++ i] < pivot) if (i == hi) break;
            while (arr[-- j] > pivot) if (j == lo) break;

            if (i >= j)
                break;
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

    // core logic
    private static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            int r = i + (int) (Math.random() * (N - i));
            swap(a, i, r);
        }
    }
}
