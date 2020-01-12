package com.janhen.algorithm.sort.shellsort;

/**
 * 希尔排序
 *
 * <pre>
 *   在原来插入排序的基础上增加偏移
 *
 * </pre>
 *
 * @author Janhen
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i += h)
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h)
                    swap(arr, j, j - h);
            h /= 3;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}