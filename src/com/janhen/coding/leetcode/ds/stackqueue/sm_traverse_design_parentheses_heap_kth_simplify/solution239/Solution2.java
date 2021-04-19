package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution239;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k || k < 0)
            return new int[]{};

        MaxQueue maxQueue = new MaxQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            maxQueue.offer(nums[i]);
            if (maxQueue.size() == k) {
                res[index++] = maxQueue.max();
                maxQueue.poll();
            }
        }
        return res;
    }

    public class MaxQueue {
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
}