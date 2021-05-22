package com.janhen.algorithm.sort.basesort.insertionsort;

public class InsertionSort {

    /**
     * 基础插入排序: 假设前 i 有序，把 i+1 的元素，向前比较和交换，插入到前面 i 当中
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // out loop, control to be insert element
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i], j;
            for (j = i; j > 0 && e < arr[j - 1]; j--) {// inner loop, iterate from front, find insert index and move
                if (e< arr[j - 1]) {
                    break;
                } else {
                    // back
                    arr[j] = arr[j - 1];
                }
            }
            // insert element
            arr[j] = e;
        }
    }

    /**
     * 作为子过程的插入排序
     *
     * @param arr
     * @param lo
     * @param hi
     */
    public static void insertSort(int[] arr, int lo, int hi) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = lo + 1; i <= hi; i++) {
            int e = arr[i], j;
            for (j = i; j > lo && e < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    public static void insertSortB(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--)
                swap(arr, j, j - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
