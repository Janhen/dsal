package com.janhen.design.queueWithMax;

//

import java.util.*;

// 21ms
public class MaxQueue2 {

    Queue<Integer>         data = new LinkedList<>();
    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2)->o2-o1);

    public void offer(int e) {
        data.offer(e);
        heap.offer(e);
    }

    public int poll() {
        if (isEmpty())
            throw new NoSuchElementException();
        int oldFront = data.poll();
        if (oldFront == heap.peek())
            heap.poll();
        return oldFront;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return data.peek();
    }

    // O(1) 获取队列中的最大值
    public int max() {
        if (isEmpty())
            throw new NoSuchElementException();
        return heap.peek();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
