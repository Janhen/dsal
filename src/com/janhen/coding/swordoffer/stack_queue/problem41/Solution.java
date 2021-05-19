package com.janhen.coding.swordoffer.stack_queue.problem41;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Solution {
    // keep small than median
    private PriorityQueue<Integer> smallerHalf = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // keep larger than median
    private PriorityQueue<Integer> largerHalf = new PriorityQueue<>();
    private int N;

    public void Insert(Integer num) {
        if (isEmpty()) {
            largerHalf.offer(num);
        } else {
            if (num > GetMedian()) {
                largerHalf.offer(num);
            } else {
                smallerHalf.offer(num);
            }
        }
        // maintain larger, smaller size
        rebalance();
        N++;
    }

    private void rebalance() {
        if (largerHalf.size() - smallerHalf.size() > 1) {
            smallerHalf.offer(largerHalf.poll());
        }
        if (smallerHalf.size() - largerHalf.size() > 1) {
            largerHalf.offer(smallerHalf.poll());
        }
    }

    public Double GetMedian() {
        if (isEmpty())
            throw new NoSuchElementException("MedianHeap is empty");
        if (largerHalf.size() == smallerHalf.size()) {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;    // int -> double, when have double to calculate
        }
        else if (largerHalf.size() > smallerHalf.size()) {
            return (double) largerHalf.peek();
        } else {
            return (double) smallerHalf.peek();
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
