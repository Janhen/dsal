package com.janhen.structures.heapAndpriorityQueue.base;

import com.janhen.TestUtil;

public class HeapSort2<E extends Comparable<E>> {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int N = arr.length;
        for (int i = (N - 2) / 2; i >= 0; i --)
            sink(arr, i, N);
        while (N > 1) {
            swap(arr, 0, -- N);
            sink(arr, 0, N);
        }
    }

    // ★类似插入排序的赋值覆盖, 最后确定正确位置优化
    private static <E extends Comparable<E>> void sink(E[] arr, int k, int N) {
        E e = arr[k];
        while (k * 2 + 1 < N) {
            int j = k * 2 + 1;
            if (j + 1 < N && arr[j].compareTo(arr[j + 1]) < 0)
                j = j + 1;
            if (e.compareTo(arr[j]) >= 0)
                break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    private static void swap(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 测试 HeapSort
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = TestUtil.generateRandomArray(N, 0, 100000);
        TestUtil.testSort("com.janhen.structures.heapAndpriorityQueue.base.HeapSort2", arr);

        return;
    }
}
