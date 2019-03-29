package com.janhen.algorithm.sort.baseSort.selectsort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return ;
        for (int i = 0; i < arr.length; i ++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j ++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            swap(arr, i, minIndex);
        }
    }
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
