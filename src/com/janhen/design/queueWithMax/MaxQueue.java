package com.janhen.design.queueWithMax;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 基于单调双向队列实现
 */
public class MaxQueue {

    private Queue<Tuple> data = new LinkedList<>();

    private Deque<Tuple> qmax = new LinkedList<>();

    private int currentIndex = 0;

    public void enquue(int val) {
        while (!qmax.isEmpty() && val >= qmax.peekLast().val)   // poll not meet
            qmax.pollLast();

        Tuple tuple = new Tuple(val, currentIndex ++);
        data.offer(tuple);
        qmax.offerLast(tuple);
    }

    public int dequeue() {
        if (data.isEmpty())
            throw new NoSuchElementException();

        if (qmax.peekFirst().idx == data.peek().idx)   // index as unique identify
            qmax.pollFirst();

        return data.peek().val;
    }

    public int max() {
        if (data.isEmpty())
            throw new NoSuchElementException();
        return qmax.peekFirst().val;
    }

    static class Tuple {
        int val;
        int idx;

        Tuple(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
