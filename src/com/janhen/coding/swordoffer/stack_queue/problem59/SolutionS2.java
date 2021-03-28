package com.janhen.coding.swordoffer.stack_queue.problem59;

import java.util.*;

public class SolutionS2 {

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

        private Queue<Tuple> data = new LinkedList<>();
 
        private Deque<Tuple> qmaxs = new LinkedList<>();

        private int currentIndex = 0;

        public void offer(int val) {
            while (!qmaxs.isEmpty() && val >= qmaxs.peekLast().val)   // poll not meet
                qmaxs.pollLast();

            Tuple tuple = new Tuple(val, currentIndex ++);
            data.offer(tuple);
            qmaxs.offerLast(tuple);
        }

        public int poll() {
            if (data.isEmpty())
                throw new NoSuchElementException();

            if (qmaxs.peekFirst().index == data.peek().index)   // index as unique identify
                qmaxs.pollFirst();

            return data.poll().val;
        }

        public int max() {
            if (data.isEmpty())
                throw new NoSuchElementException();
            return qmaxs.peekFirst().val;
        }

        public int size() {
            return data.size();
        }

        public boolean isEmpty() {
            return data.isEmpty();
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
}
