package com.janhen.structures.design.medianinstream;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Solution {
    // max heap
    private final PriorityQueue<Integer> leftSmall = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // min heap
    private final PriorityQueue<Integer> rightBig = new PriorityQueue<>();
    private int N;

    public void Insert(Integer num) {
        if (N % 2 == 0) {   // even, put rightBig AND ordered
            leftSmall.offer(num);
            rightBig.offer(leftSmall.poll());
        } else {            // odd, right N/2+1
            rightBig.offer(num);
            leftSmall.offer(rightBig.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (N % 2 == 0)
            return (leftSmall.peek() + rightBig.peek()) / 2.0;
        else
            return (double) rightBig.peek();
    }

    public boolean isEmpty() {
        return leftSmall.isEmpty() && rightBig.isEmpty();
    }
}
