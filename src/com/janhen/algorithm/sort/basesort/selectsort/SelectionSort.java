package com.janhen.algorithm.sort.basesort.selectsort;

public class SelectionSort {
    // 选择排序: 假设 i 位最小，从 i ~ N, 选择最小的和 i 位置进行交换
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // inner loop, from i+1 to find
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
