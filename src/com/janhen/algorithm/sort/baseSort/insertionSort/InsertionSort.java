package com.janhen.algorithm.sort.baseSort.insertionSort;

public class InsertionSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i ++) {
            int e = arr[i], j;
            for (j = i; j > 0 && e < arr[j - 1]; j --)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static void insertSort(int[] arr, int lo, int hi) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = lo + 1; i <= hi; i ++) {
            int e = arr[i], j;
            for (j = i; j > lo && e < arr[j - 1]; j --)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static void insertSortB(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j --)
                swap(arr, j, j - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
