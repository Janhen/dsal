package com.janhen.structures.heap;

import org.junit.Test;

public class Main {

    @Test
    public void test_IndexMaxHeap() {
        // 测试 IndexMaxHeap
        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for (int i = 0; i < N; i++)
            indexMaxHeap.insert(i, (int) (Math.random() * N));

        assert indexMaxHeap.testIndexes();
    }
}
