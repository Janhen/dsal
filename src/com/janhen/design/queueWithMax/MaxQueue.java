package com.janhen.design.queueWithMax;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MaxQueue {

  private Queue<Tuple> queue = new LinkedList<>();

  private Deque<Tuple> qmax = new LinkedList<>();

  private int currentIndex = 0;

  public void enquue(int val) {
    while (!qmax.isEmpty() && val >= qmax.peekLast().val)   // poll not meet to main monotonicity
      qmax.pollLast();

    Tuple tuple = new Tuple(val, currentIndex++);
    queue.offer(tuple);
    qmax.offerLast(tuple);
  }

  public int dequeue() {
    if (queue.isEmpty())
      throw new NoSuchElementException();
    if (qmax.peekFirst().idx == queue.peek().idx)   // index as unique identify
      qmax.pollFirst();
    return queue.peek().val;
  }

  public int max() {
    if (queue.isEmpty())
      throw new NoSuchElementException();
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
