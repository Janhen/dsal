package com.janhen.algorithm.sort.baseSort.bubblesort;

public class BubbleSortB {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = arr.length - 1; i > 0; i --)
            for (int j = 0; j < i; j ++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
