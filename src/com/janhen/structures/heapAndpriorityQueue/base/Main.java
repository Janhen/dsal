package com.janhen.structures.heapAndpriorityQueue.base;

import com.janhen.TestUtil;
import org.junit.Test;

public class Main {

    @Test
    public void test2() {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        HeapSort2 sort = new HeapSort2();
        for (int i = 0; i < testTime; i++) {
            Integer[] arr1 = TestUtil.generateRandomArray(maxSize, maxValue);
            Integer[] arr2 = TestUtil.copyArray(arr1);

            sort.sort(arr1);
            TestUtil.comparator(arr2);
            if (!TestUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        Integer[] arr = TestUtil.generateRandomArray(maxSize, maxValue);
        TestUtil.printArray(arr);
        sort.sort(arr);
        TestUtil.printArray(arr);
    }

    @Test
    public void test() {

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        HeapSort sort = new HeapSort();
        for (int i = 0; i < testTime; i++) {
            Integer[] arr1 = TestUtil.generateRandomArray(maxSize, maxValue);
            Integer[] arr2 = TestUtil.copyArray(arr1);

            sort.sort(arr1);
            TestUtil.comparator(arr2);
            if (!TestUtil.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        Integer[] arr = TestUtil.generateRandomArray(maxSize, maxValue);
        TestUtil.printArray(arr);
        sort.sort(arr);
        TestUtil.printArray(arr);
    }

    @Test
    public void testHeap() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }
}
