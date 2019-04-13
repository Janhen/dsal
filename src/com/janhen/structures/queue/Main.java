package com.janhen.structures.queue;

import com.janhen.TestUtil;
import com.janhen.structures.queue.baseLinkedList.Queue;
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


    @Test
    public void testLinkedList() {
        Queue<Integer> queue = new Queue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

        System.out.println("--------");
        for (int i = 11; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }

    @Test
    public void testLoopArray() {
        com.janhen.structures.queue.baseLoopArray.Queue<Integer> queue = new com.janhen.structures.queue.baseLoopArray.Queue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

        System.out.println("--------");
        for (int i = 11; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }
}
