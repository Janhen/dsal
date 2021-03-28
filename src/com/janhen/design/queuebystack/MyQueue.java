package com.janhen.design.queuebystack;

import java.util.NoSuchElementException;
import java.util.Stack;

class MyQueue {
  private Stack<Integer> in = new Stack<>();
  // peek element always is first put element when pop or peek operation
  private Stack<Integer> out = new Stack<>();

  public void push(int x) {
    in.push(x);
  }

  public int pop() {
    if (empty()) {
      throw new NoSuchElementException();
    }

    in2out();
    return out.pop();
  }

  public int peek() {
    if (empty()) {
      throw new NoSuchElementException();
    }

    in2out();
    return out.peek();
  }

  public boolean empty() {
    return in.isEmpty() && out.isEmpty();
  }

  private void in2out() {
    // maintain out first pop is first input
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
  }
}
