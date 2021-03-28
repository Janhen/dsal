package com.janhen.coding.swordoffer.stack_queue.problem59_2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MaxQueue {

    Deque<Tuple> data = new LinkedList<>();
    Deque<Tuple> qmax = new LinkedList<>();
    int currentIndex = 0;

    public void enquue(int val) {
        while (!qmax.isEmpty() && val >= qmax.peekLast().val)  {     // poll not meet
            qmax.pollLast();
        }

        Tuple tuple = new Tuple(val, currentIndex ++);
        data.offer(tuple);
        qmax.offerLast(tuple);
    }

    public int dequeue() {
        if (data.isEmpty())
            throw new NoSuchElementException();

        if (qmax.peekFirst().index == data.peekFirst().index)   // index as unique identify
            qmax.pollFirst();

        return data.pollFirst().val;
    }

    public int max() {
        if (data.isEmpty())
            throw new NoSuchElementException();
        return qmax.peekFirst().val;
    }


    static class Tuple {
        int val;
        int index;

        Tuple(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
