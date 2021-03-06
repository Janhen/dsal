package com.janhen.coding.swordoffer.stack_queue.problem41;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Solution_my {
    PriorityQueue<Integer> leftSmall = new PriorityQueue<>((o1, o2) -> o2 - o1);
    PriorityQueue<Integer> rightBig  = new PriorityQueue<>();
    int                    N;

    public void Insert(Integer num) {
        if (N % 2 == 0) {            // when even, put num into rightBig
            leftSmall.offer(num);
            rightBig.offer(leftSmall.poll());
        } else {    // when odd, leftSmall have N/2, rightBig have N/2+1
            rightBig.offer(num);
            leftSmall.offer(rightBig.poll());
        }
        N ++;
    }

    public Double GetMedian() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (N % 2 == 0) {
            return (leftSmall.peek() + rightBig.peek()) / 2.0;
        } else {
            return (double)rightBig.peek();
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
