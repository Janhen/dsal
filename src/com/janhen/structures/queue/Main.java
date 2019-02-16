package com.janhen.structures.queue;

import com.janhen.TestUtil;
import org.junit.Test;

import java.util.Random;

public class Main {

    @Test
    public void testDiffQueue() {
        /* loopQueue : 均摊 O(1) */
        IQueue<Integer> arrayQueue = new com.janhen.structures.queue.BaseArray.Queue<>();
        IQueue<Integer> loopQueue = new com.janhen.structures.queue.BaseLoopArray.Queue<>();
        IQueue<Integer> linkedListQueue = new com.janhen.structures.queue.BaseLinkedList.Queue<>();
        int count = 100000;

        double t1 = testQueue(arrayQueue, count);
        double t2 = testQueue(loopQueue, count);
        double t3 = testQueue(linkedListQueue, count);
        System.out.printf("arrrayQueue run : %f s\nloopQueue run : %f s\nlinkedListQueue run : %f s",t1, t2, t3);
        TestUtil.rate(t1, t2, t3);
    }

    @Test
    public void testLinkedListAndLoop() {

        IQueue<Integer> linkedListQueue = new com.janhen.structures.queue.BaseLinkedList.Queue<>();
        IQueue<Integer> loopQueue = new com.janhen.structures.queue.BaseLoopArray.Queue<>();
        int count = 100000;

        double t1 = testQueue(linkedListQueue, count);
        double t2 = testQueue(loopQueue, count);

        TestUtil.rate(t1, t2);
        System.out.printf("linkedListQueue run : %f s\nloopQueue run : %f s\nratio : %s", t1, t2);
        TestUtil.rate(t1, t2);
    }

    @Test
    public void testLoopAndArray() {
        IQueue<Integer> arrayQueue = new com.janhen.structures.queue.BaseArray.Queue<>();
        IQueue<Integer> loopQueue = new com.janhen.structures.queue.BaseLoopArray.Queue<>();
        int count = 100000;
        System.out.printf("arrrayQueue run : %f s\nloopQueue run : %f s",
                testQueue(arrayQueue, count),
                testQueue(loopQueue, count));
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
