package com.janhen.swordoffer.stack_queue.problem59;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;

// 21ms
public class SolutionS1 {
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

    static class MaxStack {

        private Stack<Integer> data = new Stack<>();
        private Stack<Integer> max = new Stack<>();

        public void push(int e) {
            if (max.isEmpty()) {
                max.push(e);
            } else if (e >= max.peek())
                max.push(e);
            data.push(e);
        }

        public int pop() {
            if (data.isEmpty())
                throw new NoSuchElementException();
            Integer oldTop = data.pop();
            if (max.peek() == oldTop)
                max.pop();
            return oldTop;
        }

        public int peek() {
            if (data.isEmpty())
                throw new NoSuchElementException();
            return data.peek();
        }

        public int max() {
            if (max.isEmpty())
                throw new NoSuchElementException();
            return max.peek();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public int size() {
            return data.size();
        }
    }

    static class MaxQueue {
        private MaxStack in = new MaxStack();
        private MaxStack out = new MaxStack();

        public void offer(int e) {
            in.push(e);
        }

        // 比 PriorityQueue+Queue 更具优势, O(1), Stack 约束多
        public int poll() {
            if (isEmpty())
                throw new NoSuchElementException();
            if (out.isEmpty()) {
                while (!in.isEmpty())
                    out.push(in.pop());
            }
            return out.pop();
        }

        public int peek() {
            if (isEmpty())
                throw new NoSuchElementException();
            if (out.isEmpty())
                while (!in.isEmpty())
                    out.push(in.pop());
            return out.peek();
        }

        // O(1) 获取队列中的最大值
        public int max() {
            if (isEmpty())
                throw new NoSuchElementException();
            return Math.max(in.isEmpty() ? Integer.MIN_VALUE : in.max(), out.isEmpty() ? Integer.MIN_VALUE : out.max());
        }

        public boolean isEmpty() {
            return in.isEmpty() && out.isEmpty();
        }

        public int size() {
            return in.size() + out.size();
        }
    }
}
