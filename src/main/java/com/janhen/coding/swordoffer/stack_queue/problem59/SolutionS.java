package com.janhen.coding.swordoffer.stack_queue.problem59;

import java.util.*;

// 176ms
public class SolutionS {

    // 实现一个带有最大值得队列
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null)
            return ret;
        if (num.length < size || size < 1)
            return ret;

        MaxQueue maxQueue = new MaxQueue();
        for (int i = 0; i < num.length; i ++) {
            maxQueue.offer(num[i]);
            if (maxQueue.size() == size) {     // maxQueue int loop size is  size-1
                ret.add(maxQueue.max());
                maxQueue.poll();
            }
        }
        return ret;
    }

    static class MaxQueue {

        // always data.size=heap.size
        private Queue<Integer>         data = new LinkedList<>();
        private PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2)->o2-o1);

        public void offer(int e) {
            data.offer(e);
            heap.offer(e);
        }

        public int poll() {
            if (isEmpty())
                throw new NoSuchElementException();
            int oldFront = data.poll();
            heap.remove(oldFront);             // O(logN)?, find oldFront, shiftDown, shiftUp
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
}
