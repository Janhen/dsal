package com.janhen.design.stackByQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyStack {

  private Queue<Integer> queue = new LinkedList<>();

  public void push(int x) {
    queue.offer(x);
    int cnt = queue.size();
    while (cnt-- > 1)
      queue.offer(queue.poll());    // NOTE: offer(poll()) 反转队列中的元素
  }

  public int pop() {
    if (empty())
      throw new NoSuchElementException();
    return queue.poll();
  }

  public int top() {
    if (empty())
      throw new NoSuchElementException();
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }

}
