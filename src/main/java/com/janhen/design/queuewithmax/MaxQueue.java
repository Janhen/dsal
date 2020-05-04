package com.janhen.design.queuewithmax;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MaxQueue {
  /** keep original enqueue order. */
  private Queue<Tuple> queue = new LinkedList<>();
  /** Monotone decreasing。 */
  private Deque<Tuple> qmax = new LinkedList<>();
  private int currentIndex = 0;

  public void offer(int val) {
    // poll not meet to main monotonicity
    while (!qmax.isEmpty() && val >= qmax.peekLast().val) {
      qmax.pollLast();
    }

    Tuple tuple = new Tuple(val, currentIndex++);
    queue.offer(tuple);
    qmax.offerLast(tuple);
  }

  public int poll() {
    if (queue.isEmpty()) {
      throw new NoSuchElementException();
    }
    Tuple oldFront = queue.poll();
    // remove relate max value
    if (qmax.peekFirst().idx == oldFront.idx) {
      qmax.pollFirst();
    }
    return oldFront.val;
  }

  public int max() {
    if (queue.isEmpty()) {
      throw new NoSuchElementException();
    }
    return qmax.peekFirst().val;
  }

  static class Tuple {
    int val;
    int idx;

    Tuple(int val, int idx) {
      this.val = val;
      this.idx = idx;
    }
  }
}
