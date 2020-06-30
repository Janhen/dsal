package com.janhen.coding.leetcode.ds.stackqueue.sm_traverse_design_parentheses_heap_kth_simplify.solution239;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0 || nums.length < k || k < 0)
        return new int[]{};

    // 1. define max queue
    MaxQueue maxQueue = new MaxQueue();
    int[] res = new int[nums.length - k + 1];
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      maxQueue.offer(nums[i]);
      // 2. maintain sliding window size
      if (maxQueue.size() == k) {
        // 3. collect result by max queue
        res[index++] = maxQueue.max();
        maxQueue.poll();
      }
    }
    return res;
  }

  class MaxQueue {
    Deque<Tuple> qmax = new LinkedList<>();   // Monotone decreasing queue(from head to tail)
    Queue<Tuple> queue = new LinkedList<>();
    int sequencer = 0;

    public void offer(int val) {
      while (!qmax.isEmpty() && val >= qmax.peekLast().val)  // maintain structure
        qmax.pollLast();
      Tuple tuple = new Tuple(val, sequencer++);
      queue.offer(tuple);
      qmax.offerLast(tuple);
    }

    public int poll() {
      if (queue.isEmpty())
        throw new NoSuchElementException();
      Tuple oldFront = queue.poll();
      if (qmax.peekFirst().index == oldFront.index)  // maintain structure
        qmax.pollFirst();
      return oldFront.val;
    }

    public int max() {
      if (queue.isEmpty())
        throw new NoSuchElementException();
      return qmax.peekFirst().val;
    }

    public int size() {
      return queue.size();
    }
  }

  class Tuple {
    int val;
    int index;

    Tuple(int val, int index) {
      this.val = val;
      this.index = index;
    }
  }
}