package com.janhen.design.stackWithMin;

import java.util.NoSuchElementException;
import java.util.Stack;

class MinStack2 {

  Stack<Integer> data = new Stack<>();
  Stack<Integer> min = new Stack<>();

  public void push(int x) {
    if (data.isEmpty()) min.push(x);
    else min.push(Math.min(x, min.peek()));
    data.push(x);
  }

  public void pop() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    min.pop();
    data.pop();
  }

  public int top() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    return data.peek();
  }

  public int getMin() {
    if (data.isEmpty())
      throw new NoSuchElementException();
    return min.peek();
  }
}
