package com.janhen.swordoffer.a_base.problem9_2;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Solution1 {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        q1.offer(val);
    }

    public int pop() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (!q1.isEmpty() && q2.isEmpty()) {
            while (q1.size() > 1)
                q2.offer(q1.poll());
            return q1.poll();
        }

        if (q1.isEmpty() && !q2.isEmpty()) {
            while (q2.size() > 1)
                q1.offer(q2.poll());
            return q2.poll();
        }
        return -1;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public int size() {
        return q1.size() + q2.size();
    }
}
