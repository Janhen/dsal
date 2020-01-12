package com.janhen.algorithm.sort.basesort.bubblesort;

/**
 * 冒泡排序优化
 *
 * <pre>
 *   优化初始数组有序, 或中间某个过程使得数组整体有序的情况
 *   time: O(n^2)
 *   space： O(1)
 * </pre>
 *
 * @author Janhen
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        boolean hasSorted = false;
        for (int i = arr.length - 1; i > 0 && !hasSorted; i --) {
            hasSorted = true;
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    hasSorted = false;
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
