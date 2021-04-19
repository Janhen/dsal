package com.janhen.design.queuewithmax;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxQueue2 {
    Queue<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void offer(int e) {
        queue.offer(e);
        heap.offer(e);
    }

    public int poll() {
        if (isEmpty())
            throw new NoSuchElementException();
        int oldFront = queue.poll();
        if (oldFront == heap.peek())
            heap.poll();  // time: O(nlogn)
        return oldFront;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return queue.peek();
    }

    // O(1) 获取队列中的最大值
    public int max() {
        if (isEmpty())
            throw new NoSuchElementException();
        return heap.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
