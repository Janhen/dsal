package com.janhen.structures.queue;

import com.janhen.TestUtil;
import org.junit.Test;

import java.util.Random;

public class Main {

    @Test
    public void testDiffQueue() {
        /* loopQueue : 均摊 O(1) */
        IQueue<Integer> loopQueue = new com.janhen.structures.queue.baseLoopArray.Queue<>();
        IQueue<Integer> linkedListQueue = new com.janhen.structures.queue.baseLinkedList.Queue<>();
        int count = 100000;

        double t2 = testQueue(loopQueue, count);
        double t3 = testQueue(linkedListQueue, count);
    }

    @Test
    public void testLinkedListAndLoop() {

        IQueue<Integer> linkedListQueue = new com.janhen.structures.queue.baseLinkedList.Queue<>();
        IQueue<Integer> loopQueue = new com.janhen.structures.queue.baseLoopArray.Queue<>();
        int count = 100000;

        double t1 = testQueue(linkedListQueue, count);
        double t2 = testQueue(loopQueue, count);

        TestUtil.rate(t1, t2);
        System.out.printf("linkedListQueue run : %f s\nloopQueue run : %f s\nratio : %s", t1, t2);
        TestUtil.rate(t1, t2);
    }

    private static double testQueue(IQueue<Integer> queue, int count) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i ++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i ++) {
            queue.dequeue();
        }
        return (System.nanoTime() - start) / 1000000000.0;
    }
}
